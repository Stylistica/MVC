$(document).ready(function(){
    var test = googleStockQuote.init(
        {
        'NASDAQ:GOOG' : 'goog',
	'NASDAQ:AAPL' : 'aapl',
        'NASDAQ:AKAM' : 'akam',//stock symbols to be entered
        
        },
        '#quotesWrapper'
        );
})


var googleStockQuote = (function(){
    var self = {};
    var _symbolsList = {};
    var _symbolArray = [];
    var _titleArray = [];
    var _queryURL;
    var _divID;

    self.init = function(symbolsList, divID){
        _symbolArray = prompt("enter values","");
        var _titleArray =  prompt("enter values","");;
		_divID = divID;

        populateSymbolTitleArrays(); //populate _symbolArray and _symbolArray
        _queryURL = 'http://finance.google.com/finance/info?client=ig&q=' 
                    +_symbolArray;

        self.getQuote();
    };

    var populateSymbolTitleArrays = function(){
      
    };

    self.getQuote = function(){
        $.ajax({
            url: _queryURL, 
            success: function(data){
                renderQuotes(eval(data));
            },
            error: function(){ alert('error'); },
            dataType: 'jsonp'
        });
    };

    var renderQuotes = function(data){

        var $quotesDIV = $(_divID);

        for(var i=0; i<data.length; i++){
            var symbol = data[i].t;
            var lastTradeTime = data[i].lt;
            var change = data[i].c;
            var changePercentage = data[i].cp;
            var l_cur = data[i].l_cur;
            var $quote = $("<div class='quote quote-" +i+ " "+ symbol +"'></div>");

            $quote.append("<div class='name'>NSE</div>");
            $quote.append("<div class='symbol'>SYMBOL: "+ symbol +"</div>");
            $quote.append("<div class='price'>Current Price: "+ l_cur +"</div>");
            $quote.append("<div class='change'>Change: "+ change +"</div>");
            $quote.append("<div class='changePercentage'>Percentage:<span>"+ changePercentage +"%</span></div>");
            $quote.append("<div class='lastTradeTime'>TradeTime "+ lastTradeTime +"</div>");

            if(parseFloat(change) > 0)
                $quote.addClass("up");
            else if (parseFloat(change) < 0)
                $quote.addClass("down");
                

            $quotesDIV.append($quote);
           
        }
    };

    return self;
}());

