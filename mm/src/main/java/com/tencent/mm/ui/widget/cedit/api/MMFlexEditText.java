package com.tencent.mm.ui.widget.cedit.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.cedit.api.c;
import com.tencent.mm.ui.widget.edittext.a;
import java.util.List;

public class MMFlexEditText extends FrameLayout implements c {
    String QFS = "com.tencent.mm.ui.widget.MMEditText";
    String QFT = "com.tencent.mm.ui.widget.cedit.api.MMCustomEditText";
    String QFU = this.QFS;
    String QFV = this.QFT;
    c QFW;
    c QFX;
    private Boolean QFY;

    public MMFlexEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(205473);
        Log.i("MicroMsg.MMFlexEditText", "init with defStyle");
        e(context, attributeSet);
        this.QFX = a(this.QFV, context, attributeSet, i2);
        this.QFW = a(this.QFU, context, attributeSet, i2);
        gZn();
        AppMethodBeat.o(205473);
    }

    public MMFlexEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(205474);
        Log.i("MicroMsg.MMFlexEditText", "init with attrs");
        e(context, attributeSet);
        this.QFX = a(this.QFV, context, attributeSet);
        this.QFW = a(this.QFU, context, attributeSet);
        gZn();
        AppMethodBeat.o(205474);
    }

    private void gZn() {
        AppMethodBeat.i(205475);
        setPadding(0, 0, 0, 0);
        refresh(true);
        AppMethodBeat.o(205475);
    }

    private void e(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(205476);
        if (attributeSet == null) {
            AppMethodBeat.o(205476);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.MMFlexEditText);
        this.QFU = obtainStyledAttributes.getString(1);
        this.QFV = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(205476);
    }

    private static c a(String str, Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(205477);
        try {
            c cVar = (c) Class.forName(str).getConstructor(Context.class, AttributeSet.class).newInstance(context, attributeSet);
            AppMethodBeat.o(205477);
            return cVar;
        } catch (Throwable th) {
            Log.e("MicroMsg.MMFlexEditText", "getEdtByClass err1:%s", Util.stackTraceToString(th));
            MMEditText mMEditText = new MMEditText(context, attributeSet);
            AppMethodBeat.o(205477);
            return mMEditText;
        }
    }

    private static c a(String str, Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(205478);
        try {
            c cVar = (c) Class.forName(str).getConstructor(Context.class, AttributeSet.class, Integer.TYPE).newInstance(context, attributeSet, Integer.valueOf(i2));
            AppMethodBeat.o(205478);
            return cVar;
        } catch (Throwable th) {
            Log.e("MicroMsg.MMFlexEditText", "getEdtByClass err2:%s", Util.stackTraceToString(th));
            MMEditText mMEditText = new MMEditText(context, attributeSet, i2);
            AppMethodBeat.o(205478);
            return mMEditText;
        }
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public Editable getText() {
        AppMethodBeat.i(205479);
        if (this.QFY.booleanValue()) {
            Editable text = this.QFW.getText();
            AppMethodBeat.o(205479);
            return text;
        }
        Editable text2 = this.QFX.getText();
        AppMethodBeat.o(205479);
        return text2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setText(CharSequence charSequence) {
        AppMethodBeat.i(205480);
        this.QFW.setText(charSequence);
        this.QFX.setText(charSequence);
        AppMethodBeat.o(205480);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setImeOptions(int i2) {
        AppMethodBeat.i(205481);
        this.QFW.setImeOptions(i2);
        this.QFX.setImeOptions(i2);
        AppMethodBeat.o(205481);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public Bundle getInputExtras(boolean z) {
        AppMethodBeat.i(205482);
        if (this.QFY.booleanValue()) {
            Bundle inputExtras = this.QFW.getInputExtras(z);
            AppMethodBeat.o(205482);
            return inputExtras;
        }
        Bundle inputExtras2 = this.QFX.getInputExtras(z);
        AppMethodBeat.o(205482);
        return inputExtras2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setBreakStrategy(int i2) {
        AppMethodBeat.i(205483);
        this.QFW.setBreakStrategy(i2);
        this.QFX.setBreakStrategy(i2);
        AppMethodBeat.o(205483);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setMaxHeight(int i2) {
        AppMethodBeat.i(205484);
        if (this.QFW != null) {
            this.QFW.setMaxHeight(i2);
        }
        if (this.QFX != null) {
            this.QFX.setMaxHeight(i2);
        }
        AppMethodBeat.o(205484);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public int getImeOptions() {
        AppMethodBeat.i(205485);
        if (this.QFY.booleanValue()) {
            int imeOptions = this.QFW.getImeOptions();
            AppMethodBeat.o(205485);
            return imeOptions;
        }
        int imeOptions2 = this.QFX.getImeOptions();
        AppMethodBeat.o(205485);
        return imeOptions2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void a(c.a aVar) {
        AppMethodBeat.i(205486);
        this.QFW.a(aVar);
        this.QFX.a(aVar);
        AppMethodBeat.o(205486);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        AppMethodBeat.i(205487);
        this.QFW.setCustomSelectionActionModeCallback(callback);
        this.QFX.setCustomSelectionActionModeCallback(callback);
        AppMethodBeat.o(205487);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public CharSequence getPasterContent() {
        AppMethodBeat.i(205488);
        if (this.QFY.booleanValue()) {
            CharSequence pasterContent = this.QFW.getPasterContent();
            AppMethodBeat.o(205488);
            return pasterContent;
        }
        CharSequence pasterContent2 = this.QFX.getPasterContent();
        AppMethodBeat.o(205488);
        return pasterContent2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void clearComposingText() {
        AppMethodBeat.i(205489);
        this.QFW.clearComposingText();
        this.QFX.clearComposingText();
        AppMethodBeat.o(205489);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public int getSelectionStart() {
        AppMethodBeat.i(205490);
        if (this.QFY.booleanValue()) {
            int selectionStart = this.QFW.getSelectionStart();
            AppMethodBeat.o(205490);
            return selectionStart;
        }
        int selectionStart2 = this.QFX.getSelectionStart();
        AppMethodBeat.o(205490);
        return selectionStart2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setKeyCodeEnterListener(MMEditText.d dVar) {
        AppMethodBeat.i(205491);
        this.QFW.setKeyCodeEnterListener(dVar);
        this.QFX.setKeyCodeEnterListener(dVar);
        AppMethodBeat.o(205491);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(205492);
        this.QFW.addTextChangedListener(textWatcher);
        this.QFX.addTextChangedListener(textWatcher);
        AppMethodBeat.o(205492);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public int length() {
        AppMethodBeat.i(205493);
        if (this.QFY.booleanValue()) {
            int length = this.QFW.length();
            AppMethodBeat.o(205493);
            return length;
        }
        int length2 = this.QFX.length();
        AppMethodBeat.o(205493);
        return length2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public int getLineCount() {
        AppMethodBeat.i(205494);
        if (this.QFY.booleanValue()) {
            int lineCount = this.QFW.getLineCount();
            AppMethodBeat.o(205494);
            return lineCount;
        }
        int lineCount2 = this.QFX.getLineCount();
        AppMethodBeat.o(205494);
        return lineCount2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void append(CharSequence charSequence) {
        AppMethodBeat.i(205495);
        this.QFW.append(charSequence);
        this.QFX.append(charSequence);
        AppMethodBeat.o(205495);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setSelection(int i2) {
        AppMethodBeat.i(205496);
        this.QFW.setSelection(i2);
        this.QFX.setSelection(i2);
        AppMethodBeat.o(205496);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final boolean gYJ() {
        AppMethodBeat.i(205497);
        if (this.QFY.booleanValue()) {
            boolean gYJ = this.QFW.gYJ();
            AppMethodBeat.o(205497);
            return gYJ;
        }
        boolean gYJ2 = this.QFX.gYJ();
        AppMethodBeat.o(205497);
        return gYJ2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public InputConnection getInputConnection() {
        AppMethodBeat.i(205498);
        if (this.QFY.booleanValue()) {
            InputConnection inputConnection = this.QFW.getInputConnection();
            AppMethodBeat.o(205498);
            return inputConnection;
        }
        InputConnection inputConnection2 = this.QFX.getInputConnection();
        AppMethodBeat.o(205498);
        return inputConnection2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void bol(String str) {
        AppMethodBeat.i(205499);
        this.QFW.bol(str);
        this.QFX.bol(str);
        AppMethodBeat.o(205499);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public float getTextSize() {
        AppMethodBeat.i(205500);
        if (this.QFY.booleanValue()) {
            float textSize = this.QFW.getTextSize();
            AppMethodBeat.o(205500);
            return textSize;
        }
        float textSize2 = this.QFX.getTextSize();
        AppMethodBeat.o(205500);
        return textSize2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setHint(CharSequence charSequence) {
        AppMethodBeat.i(205501);
        this.QFW.setHint(charSequence);
        this.QFX.setHint(charSequence);
        AppMethodBeat.o(205501);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void removeTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(205502);
        this.QFW.removeTextChangedListener(textWatcher);
        this.QFX.removeTextChangedListener(textWatcher);
        AppMethodBeat.o(205502);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setInputType(int i2) {
        AppMethodBeat.i(205503);
        this.QFW.setInputType(i2);
        this.QFX.setInputType(i2);
        AppMethodBeat.o(205503);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public int getInputType() {
        AppMethodBeat.i(205504);
        if (this.QFY.booleanValue()) {
            int inputType = this.QFW.getInputType();
            AppMethodBeat.o(205504);
            return inputType;
        }
        int inputType2 = this.QFX.getInputType();
        AppMethodBeat.o(205504);
        return inputType2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setOnDragListener(View.OnDragListener onDragListener) {
        AppMethodBeat.i(205505);
        this.QFW.setOnDragListener(onDragListener);
        this.QFX.setOnDragListener(onDragListener);
        AppMethodBeat.o(205505);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setFilters(InputFilter[] inputFilterArr) {
        AppMethodBeat.i(205506);
        this.QFW.setFilters(inputFilterArr);
        this.QFX.setFilters(inputFilterArr);
        AppMethodBeat.o(205506);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setTextColor(int i2) {
        AppMethodBeat.i(205507);
        this.QFW.setTextColor(i2);
        this.QFX.setTextColor(i2);
        AppMethodBeat.o(205507);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setEnableSendBtn(boolean z) {
        AppMethodBeat.i(205508);
        this.QFW.setEnableSendBtn(z);
        this.QFX.setEnableSendBtn(z);
        AppMethodBeat.o(205508);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public int getPasterLen() {
        AppMethodBeat.i(205509);
        if (this.QFY.booleanValue()) {
            int pasterLen = this.QFW.getPasterLen();
            AppMethodBeat.o(205509);
            return pasterLen;
        }
        int pasterLen2 = this.QFX.getPasterLen();
        AppMethodBeat.o(205509);
        return pasterLen2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(205510);
        this.QFW.setOnClickListener(onClickListener);
        this.QFX.setOnClickListener(onClickListener);
        AppMethodBeat.o(205510);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final Context gYK() {
        AppMethodBeat.i(205511);
        if (this.QFY.booleanValue()) {
            Context gYK = this.QFW.gYK();
            AppMethodBeat.o(205511);
            return gYK;
        }
        Context gYK2 = this.QFX.gYK();
        AppMethodBeat.o(205511);
        return gYK2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setBackListener(MMEditText.a aVar) {
        AppMethodBeat.i(205512);
        this.QFW.setBackListener(aVar);
        this.QFX.setBackListener(aVar);
        AppMethodBeat.o(205512);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void addOnLayoutChangeListener(View.OnLayoutChangeListener onLayoutChangeListener) {
        AppMethodBeat.i(205513);
        this.QFW.addOnLayoutChangeListener(onLayoutChangeListener);
        this.QFX.addOnLayoutChangeListener(onLayoutChangeListener);
        AppMethodBeat.o(205513);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final int gYL() {
        AppMethodBeat.i(205514);
        if (this.QFY.booleanValue()) {
            int gYL = this.QFW.gYL();
            AppMethodBeat.o(205514);
            return gYL;
        }
        int gYL2 = this.QFX.gYL();
        AppMethodBeat.o(205514);
        return gYL2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public TextPaint getPaint() {
        AppMethodBeat.i(205515);
        if (this.QFY.booleanValue()) {
            TextPaint paint = this.QFW.getPaint();
            AppMethodBeat.o(205515);
            return paint;
        }
        TextPaint paint2 = this.QFX.getPaint();
        AppMethodBeat.o(205515);
        return paint2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void removeOnLayoutChangeListener(View.OnLayoutChangeListener onLayoutChangeListener) {
        AppMethodBeat.i(205516);
        this.QFW.removeOnLayoutChangeListener(onLayoutChangeListener);
        this.QFX.removeOnLayoutChangeListener(onLayoutChangeListener);
        AppMethodBeat.o(205516);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setVisibility(int i2) {
        AppMethodBeat.i(205517);
        if (this.QFY.booleanValue()) {
            this.QFW.setVisibility(i2);
            AppMethodBeat.o(205517);
            return;
        }
        this.QFX.setVisibility(i2);
        AppMethodBeat.o(205517);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void onPause() {
        AppMethodBeat.i(205518);
        if (this.QFY.booleanValue()) {
            this.QFW.onPause();
            AppMethodBeat.o(205518);
            return;
        }
        this.QFX.onPause();
        AppMethodBeat.o(205518);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void destroy() {
        AppMethodBeat.i(205519);
        this.QFX.destroy();
        this.QFW.destroy();
        AppMethodBeat.o(205519);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void a(List<String> list, List<String> list2, String str, a.e eVar) {
        AppMethodBeat.i(205520);
        this.QFX.a(list, list2, str, eVar);
        this.QFW.a(list, list2, str, eVar);
        AppMethodBeat.o(205520);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void gYF() {
        AppMethodBeat.i(205521);
        if (this.QFY.booleanValue()) {
            this.QFW.gYF();
            AppMethodBeat.o(205521);
            return;
        }
        this.QFX.gYF();
        AppMethodBeat.o(205521);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void CS(boolean z) {
        AppMethodBeat.i(205522);
        if (this.QFY.booleanValue()) {
            this.QFW.CS(z);
            AppMethodBeat.o(205522);
            return;
        }
        this.QFX.CS(z);
        AppMethodBeat.o(205522);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public int getVisibility() {
        AppMethodBeat.i(205523);
        if (this.QFY == null) {
            int visibility = super.getVisibility();
            AppMethodBeat.o(205523);
            return visibility;
        } else if (this.QFY.booleanValue()) {
            int visibility2 = this.QFW.getVisibility();
            AppMethodBeat.o(205523);
            return visibility2;
        } else {
            int visibility3 = this.QFX.getVisibility();
            AppMethodBeat.o(205523);
            return visibility3;
        }
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(205524);
        this.QFX.setOnTouchListener(onTouchListener);
        this.QFW.setOnTouchListener(onTouchListener);
        AppMethodBeat.o(205524);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(205525);
        this.QFX.setOnFocusChangeListener(onFocusChangeListener);
        this.QFW.setOnFocusChangeListener(onFocusChangeListener);
        AppMethodBeat.o(205525);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        AppMethodBeat.i(205526);
        this.QFX.setOnLongClickListener(onLongClickListener);
        this.QFW.setOnLongClickListener(onLongClickListener);
        AppMethodBeat.o(205526);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void refresh(boolean z) {
        AppMethodBeat.i(205527);
        Log.i("MicroMsg.MMFlexEditText", "refresh isUseSys:%s, mUseSys:%s", Boolean.valueOf(z), this.QFY);
        if (this.QFX.gYH()) {
            z = true;
        }
        if (this.QFY == null || this.QFY.booleanValue() != z) {
            this.QFY = Boolean.valueOf(z);
            if (this.QFY.booleanValue()) {
                if (this.QFW.gYI() == null) {
                    addView(this.QFW.gYG());
                }
                this.QFW.setVisibility(0);
                if (this.QFX.gYI() != null) {
                    this.QFX.setVisibility(8);
                    AppMethodBeat.o(205527);
                    return;
                }
            } else {
                b.aow(9);
                if (this.QFW.gYI() != null) {
                    this.QFW.setVisibility(8);
                }
                if (this.QFX.gYI() == null) {
                    addView(this.QFX.gYG());
                }
                this.QFX.setVisibility(0);
            }
            AppMethodBeat.o(205527);
            return;
        }
        AppMethodBeat.o(205527);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final View gYG() {
        AppMethodBeat.i(205528);
        if (this.QFY.booleanValue()) {
            View gYG = this.QFW.gYG();
            AppMethodBeat.o(205528);
            return gYG;
        }
        View gYG2 = this.QFX.gYG();
        AppMethodBeat.o(205528);
        return gYG2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setPasterLen(int i2) {
        AppMethodBeat.i(205529);
        this.QFW.setPasterLen(i2);
        this.QFX.setPasterLen(i2);
        AppMethodBeat.o(205529);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final boolean gYH() {
        return false;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final ViewParent gYI() {
        AppMethodBeat.i(205530);
        ViewParent parent = getParent();
        AppMethodBeat.o(205530);
        return parent;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setAlpha(float f2) {
        AppMethodBeat.i(205531);
        this.QFX.setAlpha(f2);
        this.QFW.setAlpha(f2);
        AppMethodBeat.o(205531);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void clearFocus() {
        AppMethodBeat.i(205532);
        this.QFX.clearFocus();
        this.QFW.clearFocus();
        AppMethodBeat.o(205532);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setTextSize(int i2, float f2) {
        AppMethodBeat.i(205533);
        if (this.QFY.booleanValue()) {
            if (this.QFW != null) {
                this.QFW.setTextSize(i2, f2);
                AppMethodBeat.o(205533);
                return;
            }
        } else if (this.QFX != null) {
            this.QFX.setTextSize(i2, f2);
        }
        AppMethodBeat.o(205533);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setContentDescription(CharSequence charSequence) {
        AppMethodBeat.i(205534);
        super.setContentDescription(charSequence);
        if (this.QFY.booleanValue()) {
            if (this.QFW != null) {
                this.QFW.setContentDescription(charSequence);
                AppMethodBeat.o(205534);
                return;
            }
        } else if (this.QFX != null) {
            this.QFX.setContentDescription(charSequence);
        }
        AppMethodBeat.o(205534);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    @SuppressLint({"GetContentDescriptionOverride"})
    public CharSequence getContentDescription() {
        AppMethodBeat.i(205535);
        if (this.QFY.booleanValue()) {
            if (this.QFW != null) {
                CharSequence contentDescription = this.QFW.getContentDescription();
                AppMethodBeat.o(205535);
                return contentDescription;
            }
        } else if (this.QFX != null) {
            CharSequence contentDescription2 = this.QFX.getContentDescription();
            AppMethodBeat.o(205535);
            return contentDescription2;
        }
        CharSequence contentDescription3 = super.getContentDescription();
        AppMethodBeat.o(205535);
        return contentDescription3;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public CharSequence getHint() {
        AppMethodBeat.i(205536);
        if (this.QFY.booleanValue()) {
            if (this.QFW != null) {
                CharSequence hint = this.QFW.getHint();
                AppMethodBeat.o(205536);
                return hint;
            }
        } else if (this.QFX != null) {
            CharSequence hint2 = this.QFX.getHint();
            AppMethodBeat.o(205536);
            return hint2;
        }
        AppMethodBeat.o(205536);
        return null;
    }
}
