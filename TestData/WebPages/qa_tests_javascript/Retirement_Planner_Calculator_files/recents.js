
/*
KJ=new Object();
KJ.KJECalcNavigation = document.getElementById("KJECalcNavigation");
KJ.KJECalcNavigation2 = document.getElementById("KJECalcNavigation2");
KJ.KJENavButton = document.getElementById("KJENavButton");
KJ.ShowNav = false;

KJ.KJECalcNav = function(){
    if (KJ.ShowNav) {
        KJ.KJECalcNavigation.style.display='none';
        if (window.innerWidth < 500) KJ.KJECalcNavigation2.style.display='none';
        KJ.KJENavButton.innerHTML='<br><br>More&darr;';
        KJ.ShowNav = false;
    }
    else    {
        KJ.KJECalcNavigation.style.display='block';
        KJ.KJECalcNavigation2.style.display='inline-block';
        KJ.KJENavButton.innerHTML='<br><br>Less&uarr;';
        KJ.ShowNav = true;
    }
};

*/

function KJESetRecents(rvt_div){
    if (!rvt_div) return;

    var aList = new Array();
    for (var i = 0; i < localStorage.length; i++){
        aList[i] = localStorage.key(i) ;
    }
    aList = aList.sort();

    var iList = rvt_div;
    var sList = "";
    for (var i = 0; i < aList.length; i++){
        //  only care about entries without a "_" in them.
        var i_ = aList[i].indexOf("_");
        if (i_ < 0) {
            var name = (aList[i]+"_name");
            var iCutOff = aList[i].indexOf('#');
            if (iCutOff>0) sIndex = aList[i].substring(0,iCutOff);
            else sIndex =  aList[i];

            var sHref = sIndex +"_href";
            var sTitle = sIndex +"_title";
            if (localStorage.getItem(sTitle)!=null) {
                sList += "<li><a href='"+ localStorage.getItem(sHref)+"?KJEData="+ localStorage.getItem(aList[i]) +"'>"+localStorage.getItem(sTitle)+(iCutOff>0?" : "+localStorage.getItem(name) :"")+"</a>";
            }
        }
    }
    iList.innerHTML = '<div class="wrapper"><div class="link_quote"><span class="fa-calculator"></span></div><div class="KJERecentTitle">Recent calculations</div></div><ul class="KJERecentList">'+sList+'</ul>';

}
KJESetRecents(document.getElementById("KJERecents"));


