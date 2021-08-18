var MOVE = 580, CURRENT = 0;
var IMGS = [
        "img/11.jpg", "img/22.jpg", 'img/33.jpg'
];
var TITLES = [
        "Ajax"
];
jQuery (function ($)
{
	var dric = $ ('div#div_roll_img_cc'), um = dric.children ('ul');
	var smalldiv = $ ('div.roll_small_signimg_div');
	var ra = $('div.roll_title a:first');
	$ (IMGS).each (function (i, dom)
	{
		um.append('<li><a href="#"><div class="roll_img_kk" style="background: url(\''+dom+'\') no-repeat; width: 580px; height: 435px;"></div> </a></li>');
		smalldiv.append('<img class="roll_small_signimg"  src="'+dom+'">');
	});
	var sc = smalldiv.children ('img');
	sc.eq(CURRENT).addClass('current_con');
	ra.text(TITLES[CURRENT]);
	
	var ro = $ ('div.roll_opacity'), r = $ ('div.roll'), btn = $('div[class*="btn_picturn"]');
	$ ('div.box1').mouseenter (function ()
	{
		stop ();
		ro.show ();
		r.show ();
		btn.show();
	}).mouseleave (function ()
	{
		ro.hide ();
		r.hide ();
		btn.hide();
		run (btn.eq(1));
	});
	
	var uc = um.children ('li'), isRunning = false;
	var len = uc.length;
	uc.each (function (i, dom)
	{
		$ (this).attr ('index', i);
	});
	sc.click (function ()
	{
		if (isRunning)
		{
			return false;
		}
		$ (this).addClass ('current_con').siblings ('img[class*="current_con"]').removeClass ('current_con');
		var index = $ (this).index ();
		if (index == CURRENT)
		{
			return false;
		}
		// left
		else if (index < CURRENT)
		{
			for ( var i = index; i < len; i++)
			{
				uc.filter ('li[index=' + i + ']').appendTo (um);
			}
			for ( var i = 0; i < index; i++)
			{
				uc.filter ('li[index=' + i + ']').appendTo (um);
			}
			dric.css ('left', '-' + (MOVE * (CURRENT - index)) + 'px');
			dric.animate (
			{
				left : "0px"
			}, "slow", function ()
			{
				isRunning = false;
			});
		}
		// right
		else if (index > CURRENT)
		{
			dric.animate (
			{
				left : "-" + (MOVE * (index - CURRENT)) + "px"
			}, "slow", function ()
			{
				for ( var i = index; i < len; i++)
				{
					uc.filter ('li[index=' + i + ']').appendTo (um);
				}
				for ( var i = 0; i < index; i++)
				{
					uc.filter ('li[index=' + i + ']').appendTo (um);
				}
				dric.css ('left', '0px');
				isRunning = false;
			});
		}
		CURRENT = index;
		ra.text(TITLES[CURRENT]);
		isRunning = true;
	});
	
	var changeImg = function (isRight)
	{
		smalldiv.children ('img:eq(' + CURRENT + ')').removeClass ('current_con');
		if (!isRight)
        {
			CURRENT--;
			CURRENT = CURRENT < 0 ? len - 1 : CURRENT;
        }
		else 
		{
			CURRENT++;
			CURRENT = CURRENT > len - 1 ? 0 : CURRENT;
		}
		ra.text(TITLES[CURRENT]);
		smalldiv.children ('img:eq(' + CURRENT + ')').addClass ('current_con');
	};
	
	btn.eq(0).click (function ()
	{
		if (isRunning)
		{
			return false;
		}
		changeImg(false);
		isRunning = true;
		dric.find ('li:last').insertBefore (dric.find ('li:first'));
		dric.css ('left', '-' + MOVE + 'px');
		dric.animate (
		{
			left : '0px'
		}, 'slow', function ()
		{
			isRunning = false;
		});
	});
	
	btn.eq(1).click (function ()
	{
		if (isRunning)
		{
			return false;
		}
		changeImg(true);
		isRunning = true;
		dric.animate (
		{
			left : '-' + MOVE + 'px'
		}, 'slow', function ()
		{
			dric.find ('li:first').insertAfter (dric.find ('li:last'));
			dric.css ('left', '0px');
			isRunning = false;
		});
	});
	run (btn.eq(1));
});

var INTERVAL = null //, SLEEP = 2000;
var run = function (btn)
{
	if (!INTERVAL)
	{
		INTERVAL = setInterval (function ()
		{
			btn.triggerHandler ('click');
		}, SLEEP);
	}
};

var stop = function ()
{
	if (!!INTERVAL)
    {
	    clearInterval (INTERVAL);
	    INTERVAL = null;
    }
};
