package com.tencent.kinda.framework.widget.base;

import android.widget.LinearLayout;
import com.tencent.kinda.gen.ClearButtonMode;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.EditTextRestrictType;
import com.tencent.kinda.gen.KEditTextOnTextBeginChangeCallback;
import com.tencent.kinda.gen.KEditTextOnTextChangedCallback;
import com.tencent.kinda.gen.KEditTextOnTextEndEditingCallback;
import com.tencent.kinda.gen.KPayEditText;
import com.tencent.kinda.gen.KeyboardType;
import com.tencent.kinda.gen.PayEditState;
import com.tencent.kinda.gen.TextAlign;

public class KindaPayEditTextImpl extends MMKView<LinearLayout> implements KPayEditText {
    @Override // com.tencent.kinda.gen.KPayEditText
    public String getInputText() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KPayEditText
    public void setEditState(PayEditState payEditState) {
    }

    @Override // com.tencent.kinda.gen.KPayEditText
    public PayEditState getEditState() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KPayEditText
    public void setSalt(String str) {
    }

    @Override // com.tencent.kinda.gen.KPayEditText
    public String getSalt() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setText(String str) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public String getText() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setTextSize(float f2) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public float getTextSize() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setTextColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public DynamicColor getTextColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setTextFont(String str) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public String getTextFont() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setTextAlign(TextAlign textAlign) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public TextAlign getTextAlign() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setHint(String str) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public String getHint() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setHintColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public DynamicColor getHintColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setMaxLength(int i2) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public int getMaxLength() {
        return 0;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setKeyboardType(KeyboardType keyboardType) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public KeyboardType getKeyboardType() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setSelection(int i2) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public int getSelection() {
        return 0;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setFocus(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public boolean getFocus() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setTintColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public DynamicColor getTintColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setClearButtonMode(ClearButtonMode clearButtonMode) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public ClearButtonMode getClearButtonMode() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setOnTextBeginChangeCallback(KEditTextOnTextBeginChangeCallback kEditTextOnTextBeginChangeCallback) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setOnTextChangedCallback(KEditTextOnTextChangedCallback kEditTextOnTextChangedCallback) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public String encryptWith3Des() {
        return "";
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setEnabled(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public boolean getEnabled() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setRestrictType(EditTextRestrictType editTextRestrictType) {
    }

    @Override // com.tencent.kinda.gen.KEditText
    public EditTextRestrictType getRestrictType() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KEditText
    public void setOnTextEndEditingCallback(KEditTextOnTextEndEditingCallback kEditTextOnTextEndEditingCallback) {
    }
}
