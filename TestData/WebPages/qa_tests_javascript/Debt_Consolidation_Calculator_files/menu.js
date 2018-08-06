var showMenu = function() { handleClickNav('KJECalculatorMenu'); };
var showSubmenu = function() { handleClickNav('KJECalculatorSubMenu'); };
var showCalculators= function() { handleClickNav('KJECalculatorSubMenu'); };
var showSearch = function() { handleClickNav('cse','gsc-i-id1'); };
var handleClickNav = function(sNavItem, sNavFocus) {

    var eNavItem=document.getElementById(sNavItem);
    if (eNavItem){
        var bShow = false;

        if (eNavItem.style.display=='' && sNavItem=='KJECalculatorMenu')
            bShow=true;
        else if (eNavItem.style.display=='' && sNavItem=='KJECalculatorSubMenu')
            bShow=false;
        else if (eNavItem.style.display!='none') {
            bShow=false;
        }
        else {
            bShow=true;
        }
    }

    if (bShow) {
        eNavItem.style.display='block';
        if (sNavFocus) {
            var eNavItemInput = document.getElementById(sNavFocus);
            if (eNavItemInput) eNavItemInput.focus();
        }
    }
    else eNavItem.style.display=(sNavItem=='KJECalculatorMenu'?'':'none');
    return false;
};


