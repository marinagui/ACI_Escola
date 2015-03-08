function doGetCaretPosition(oField) {

    // Initialize
    var iCaretPos = 0;

    // IE Support
    if (document.selection) {

        // Set focus on the element
        oField.focus();

        // To get cursor position, get empty selection range
        var oSel = document.selection.createRange();

        // Move selection start to 0 position
        oSel.moveStart('character', -oField.value.length);

        // The caret position is selection length
        iCaretPos = oSel.text.length;
    }

        // Firefox support
    else if (oField.selectionStart || oField.selectionStart == '0')
        iCaretPos = oField.selectionStart;

    // Return results
    return (iCaretPos);
}

function setCaretPosition(ctrl, pos) {
    if (ctrl.setSelectionRange) {
        ctrl.focus();
        ctrl.setSelectionRange(pos, pos);
    }
    else if (ctrl.createTextRange) {
        var range = ctrl.createTextRange();
        range.collapse(true);
        range.moveEnd('character', pos);
        range.moveStart('character', pos);
        range.select();
    }
}
var valAnt = "";
function mask(n, m) {
    var t = $(n);
    var val = t.val();
    var result = "";
    var pos = doGetCaretPosition(n);
    t.attr("maxlength", m.length)

    if (!(val.length < valAnt.length)) {
        for (var i = 0, j = 0; i < val.length && j < m.length; i++, j++) {
            var charMask = m[j];
            var charAtu = val[i];
            if (charMask == 'A' || charMask == 'a') {
                if (isNaN(charAtu)) {
                    result += charAtu;
                } else {
                    j--;
                }
            } else if (charMask == '9') {
                if (!isNaN(charAtu)) {
                    result += charAtu;
                } else {
                    j--;
                }
            } else {
                result += charMask;
                while (val.indexOf(charMask) > 0) {
                    val = val.replace(charMask, "");
                }

                i--;
            }
        }
        if (pos > 0) {
            if ((m[pos - 1] != 'A') && (m[pos - 1] != 'a') && (m[pos - 1] != '9')) {
                pos++;
            }
        }
        t.val(result);
        setCaretPosition(n, pos);
    }

    valAnt = t.val();

}