package io.flutter.plugin.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.provider.Settings;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.c.m;
import java.util.Arrays;
import java.util.HashMap;

/* access modifiers changed from: package-private */
public final class b extends BaseInputConnection {
    private final Layout OVt;
    private final m SOi;
    private final boolean SSA;
    boolean SSB;
    private a SSC;
    private final int SSu;
    private final Editable SSv;
    private final EditorInfo SSw;
    private int SSx;
    private InputMethodManager SSy;
    private a SSz;
    private final View yFg;

    /* access modifiers changed from: package-private */
    public class a {
        public int SSD;
        public int SSE;
        public int selectionEnd;
        public int selectionStart;
        public String text;

        public a(Editable editable) {
            AppMethodBeat.i(214898);
            this.selectionStart = Selection.getSelectionStart(editable);
            this.selectionEnd = Selection.getSelectionEnd(editable);
            this.SSD = BaseInputConnection.getComposingSpanStart(editable);
            this.SSE = BaseInputConnection.getComposingSpanEnd(editable);
            this.text = editable.toString();
            AppMethodBeat.o(214898);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(214899);
            if (obj == this) {
                AppMethodBeat.o(214899);
                return true;
            } else if (!(obj instanceof a)) {
                AppMethodBeat.o(214899);
                return false;
            } else {
                a aVar = (a) obj;
                if (this.selectionStart == aVar.selectionStart && this.selectionEnd == aVar.selectionEnd && this.SSD == aVar.SSD && this.SSE == aVar.SSE && this.text.equals(aVar.text)) {
                    AppMethodBeat.o(214899);
                    return true;
                }
                AppMethodBeat.o(214899);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(214900);
            int hashCode = ((((((((this.selectionStart + 31) * 31) + this.selectionEnd) * 31) + this.SSD) * 31) + this.SSE) * 31) + this.text.hashCode();
            AppMethodBeat.o(214900);
            return hashCode;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private b(View view, int i2, m mVar, Editable editable, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        boolean z = false;
        AppMethodBeat.i(214891);
        this.SSB = false;
        this.yFg = view;
        this.SSu = i2;
        this.SOi = mVar;
        this.SSv = editable;
        this.SSw = editorInfo;
        this.SSx = 0;
        this.SSz = new a(flutterJNI);
        this.OVt = new DynamicLayout(this.SSv, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.SSy = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (this.SSy.getCurrentInputMethodSubtype() != null && Build.VERSION.SDK_INT >= 21 && Build.MANUFACTURER.equals("samsung")) {
            z = Settings.Secure.getString(this.yFg.getContext().getContentResolver(), "default_input_method").contains("Samsung");
        }
        this.SSA = z;
        AppMethodBeat.o(214891);
    }

    public b(View view, int i2, m mVar, Editable editable, EditorInfo editorInfo) {
        this(view, i2, mVar, editable, editorInfo, new FlutterJNI());
        AppMethodBeat.i(214892);
        AppMethodBeat.o(214892);
    }

    private void hxm() {
        AppMethodBeat.i(9944);
        if (this.SSx > 0) {
            AppMethodBeat.o(9944);
            return;
        }
        a aVar = new a(this.SSv);
        if (!this.SSB || !aVar.equals(this.SSC)) {
            this.SSy.updateSelection(this.yFg, aVar.selectionStart, aVar.selectionEnd, aVar.SSD, aVar.SSE);
            m mVar = this.SOi;
            int i2 = this.SSu;
            String str = aVar.text;
            int i3 = aVar.selectionStart;
            int i4 = aVar.selectionEnd;
            int i5 = aVar.SSD;
            int i6 = aVar.SSE;
            new StringBuilder("Sending message to update editing state: \nText: ").append(str).append("\nSelection start: ").append(i3).append("\nSelection end: ").append(i4).append("\nComposing start: ").append(i5).append("\nComposing end: ").append(i6);
            io.flutter.a.hwd();
            HashMap<Object, Object> g2 = m.g(str, i3, i4, i5, i6);
            mVar.bbv.a("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i2), g2), null);
            this.SSB = true;
            this.SSC = aVar;
            AppMethodBeat.o(9944);
            return;
        }
        AppMethodBeat.o(9944);
    }

    public final Editable getEditable() {
        return this.SSv;
    }

    public final boolean beginBatchEdit() {
        AppMethodBeat.i(9945);
        this.SSx++;
        boolean beginBatchEdit = super.beginBatchEdit();
        AppMethodBeat.o(9945);
        return beginBatchEdit;
    }

    public final boolean endBatchEdit() {
        AppMethodBeat.i(9946);
        boolean endBatchEdit = super.endBatchEdit();
        this.SSx--;
        hxm();
        AppMethodBeat.o(9946);
        return endBatchEdit;
    }

    public final boolean commitText(CharSequence charSequence, int i2) {
        AppMethodBeat.i(9947);
        boolean commitText = super.commitText(charSequence, i2);
        this.SSB = false;
        AppMethodBeat.o(9947);
        return commitText;
    }

    public final boolean deleteSurroundingText(int i2, int i3) {
        AppMethodBeat.i(9948);
        if (Selection.getSelectionStart(this.SSv) == -1) {
            AppMethodBeat.o(9948);
            return true;
        }
        boolean deleteSurroundingText = super.deleteSurroundingText(i2, i3);
        this.SSB = false;
        AppMethodBeat.o(9948);
        return deleteSurroundingText;
    }

    public final boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        AppMethodBeat.i(214893);
        boolean deleteSurroundingTextInCodePoints = super.deleteSurroundingTextInCodePoints(i2, i3);
        this.SSB = false;
        AppMethodBeat.o(214893);
        return deleteSurroundingTextInCodePoints;
    }

    public final boolean setComposingRegion(int i2, int i3) {
        AppMethodBeat.i(9949);
        boolean composingRegion = super.setComposingRegion(i2, i3);
        this.SSB = false;
        AppMethodBeat.o(9949);
        return composingRegion;
    }

    public final boolean setComposingText(CharSequence charSequence, int i2) {
        boolean composingText;
        AppMethodBeat.i(9950);
        if (charSequence.length() == 0) {
            composingText = super.commitText(charSequence, i2);
        } else {
            composingText = super.setComposingText(charSequence, i2);
        }
        this.SSB = false;
        AppMethodBeat.o(9950);
        return composingText;
    }

    public final boolean finishComposingText() {
        AppMethodBeat.i(214894);
        boolean finishComposingText = super.finishComposingText();
        if (this.SSA && Build.VERSION.SDK_INT >= 21) {
            CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
            builder.setComposingText(-1, "");
            this.SSy.updateCursorAnchorInfo(this.yFg, builder.build());
        }
        this.SSB = false;
        AppMethodBeat.o(214894);
        return finishComposingText;
    }

    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i2) {
        AppMethodBeat.i(214895);
        ExtractedText extractedText = new ExtractedText();
        extractedText.selectionStart = Selection.getSelectionStart(this.SSv);
        extractedText.selectionEnd = Selection.getSelectionEnd(this.SSv);
        extractedText.text = this.SSv.toString();
        AppMethodBeat.o(214895);
        return extractedText;
    }

    public final boolean clearMetaKeyStates(int i2) {
        AppMethodBeat.i(214896);
        boolean clearMetaKeyStates = super.clearMetaKeyStates(i2);
        this.SSB = false;
        AppMethodBeat.o(214896);
        return clearMetaKeyStates;
    }

    public final boolean setSelection(int i2, int i3) {
        AppMethodBeat.i(9951);
        boolean selection = super.setSelection(i2, i3);
        this.SSB = false;
        hxm();
        AppMethodBeat.o(9951);
        return selection;
    }

    private static int a(int i2, Editable editable) {
        AppMethodBeat.i(9952);
        int max = Math.max(0, Math.min(editable.length(), i2));
        if (max != i2) {
            new StringBuilder("Text selection index was clamped (").append(i2).append("->").append(max).append(") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
            io.flutter.a.hwe();
        }
        AppMethodBeat.o(9952);
        return max;
    }

    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        int i2;
        int i3;
        boolean z;
        int i4;
        boolean z2;
        AppMethodBeat.i(9953);
        this.SSB = false;
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 67) {
                int a2 = a(Selection.getSelectionStart(this.SSv), this.SSv);
                int a3 = a(Selection.getSelectionEnd(this.SSv), this.SSv);
                if (a2 != a3 || a2 <= 0) {
                    i2 = a2;
                } else {
                    a aVar = this.SSz;
                    Editable editable = this.SSv;
                    if (a2 <= 1) {
                        i2 = 0;
                    } else {
                        int codePointBefore = Character.codePointBefore(editable, a2);
                        int charCount = Character.charCount(codePointBefore);
                        int i5 = a2 - charCount;
                        if (i5 == 0) {
                            i2 = 0;
                        } else if (codePointBefore == 10) {
                            if (Character.codePointBefore(editable, i5) == 13) {
                                charCount++;
                            }
                            i2 = a2 - charCount;
                        } else if (aVar.atz(codePointBefore)) {
                            int codePointBefore2 = Character.codePointBefore(editable, i5);
                            int charCount2 = i5 - Character.charCount(codePointBefore2);
                            int i6 = 1;
                            while (charCount2 > 0 && aVar.atz(codePointBefore2)) {
                                codePointBefore2 = Character.codePointBefore(editable, charCount2);
                                charCount2 -= Character.charCount(codePointBefore2);
                                i6++;
                            }
                            if (i6 % 2 == 0) {
                                charCount += 2;
                            }
                            i2 = a2 - charCount;
                        } else if (codePointBefore == 8419) {
                            int codePointBefore3 = Character.codePointBefore(editable, i5);
                            int charCount3 = i5 - Character.charCount(codePointBefore3);
                            if (charCount3 > 0 && aVar.aty(codePointBefore3)) {
                                int codePointBefore4 = Character.codePointBefore(editable, charCount3);
                                if (a.atA(codePointBefore4)) {
                                    charCount += Character.charCount(codePointBefore4) + Character.charCount(codePointBefore3);
                                }
                            } else if (a.atA(codePointBefore3)) {
                                charCount += Character.charCount(codePointBefore3);
                            }
                            i2 = a2 - charCount;
                        } else {
                            if (codePointBefore == 917631) {
                                codePointBefore = Character.codePointBefore(editable, i5);
                                i5 -= Character.charCount(codePointBefore);
                                int i7 = charCount;
                                while (i5 > 0) {
                                    if (917536 > codePointBefore || codePointBefore > 917630) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    if (!z2) {
                                        break;
                                    }
                                    int charCount4 = Character.charCount(codePointBefore) + i7;
                                    codePointBefore = Character.codePointBefore(editable, i5);
                                    i5 -= Character.charCount(codePointBefore);
                                    i7 = charCount4;
                                }
                                if (!aVar.atx(codePointBefore)) {
                                    i2 = a2 - 2;
                                } else {
                                    charCount = Character.charCount(codePointBefore) + i7;
                                }
                            }
                            if (aVar.aty(codePointBefore)) {
                                codePointBefore = Character.codePointBefore(editable, i5);
                                if (aVar.atx(codePointBefore)) {
                                    charCount += Character.charCount(codePointBefore);
                                    i5 -= charCount;
                                }
                                i3 = charCount;
                                i2 = a2 - i3;
                            }
                            if (aVar.atx(codePointBefore)) {
                                boolean z3 = false;
                                int i8 = 0;
                                int i9 = i5;
                                int i10 = charCount;
                                int i11 = codePointBefore;
                                while (true) {
                                    if (z3) {
                                        i3 = i10 + Character.charCount(i11) + i8 + 1;
                                        z = false;
                                    } else {
                                        z = z3;
                                        i3 = i10;
                                    }
                                    int i12 = 0;
                                    if (!aVar.SNV.nativeFlutterTextUtilsIsEmojiModifier(i11)) {
                                        if (i9 > 0) {
                                            int codePointBefore5 = Character.codePointBefore(editable, i9);
                                            int charCount5 = i9 - Character.charCount(codePointBefore5);
                                            if (codePointBefore5 == 8205) {
                                                z = true;
                                                codePointBefore5 = Character.codePointBefore(editable, charCount5);
                                                charCount5 -= Character.charCount(codePointBefore5);
                                                if (charCount5 > 0 && aVar.aty(codePointBefore5)) {
                                                    int codePointBefore6 = Character.codePointBefore(editable, charCount5);
                                                    i12 = Character.charCount(codePointBefore6);
                                                    i9 = charCount5 - Character.charCount(codePointBefore6);
                                                    i11 = codePointBefore6;
                                                }
                                            }
                                            i9 = charCount5;
                                            i11 = codePointBefore5;
                                        }
                                        if (i9 == 0 || !z || !aVar.atx(i11)) {
                                            break;
                                        }
                                        i8 = i12;
                                        z3 = z;
                                        i10 = i3;
                                    } else {
                                        int codePointBefore7 = Character.codePointBefore(editable, i9);
                                        int charCount6 = i9 - Character.charCount(codePointBefore7);
                                        if (charCount6 <= 0 || !aVar.aty(codePointBefore7)) {
                                            i4 = 0;
                                        } else {
                                            int codePointBefore8 = Character.codePointBefore(editable, charCount6);
                                            if (aVar.atx(codePointBefore8)) {
                                                i4 = Character.charCount(codePointBefore8);
                                                Character.charCount(codePointBefore8);
                                                codePointBefore7 = codePointBefore8;
                                            }
                                        }
                                        if (aVar.SNV.nativeFlutterTextUtilsIsEmojiModifierBase(codePointBefore7)) {
                                            i3 += i4 + Character.charCount(codePointBefore7);
                                        }
                                    }
                                }
                                i2 = a2 - i3;
                            }
                            i3 = charCount;
                            i2 = a2 - i3;
                        }
                    }
                }
                if (a3 > i2) {
                    Selection.setSelection(this.SSv, i2);
                    this.SSv.delete(i2, a3);
                    hxm();
                    AppMethodBeat.o(9953);
                    return true;
                }
                AppMethodBeat.o(9953);
                return false;
            } else if (keyEvent.getKeyCode() == 21) {
                int selectionStart = Selection.getSelectionStart(this.SSv);
                int selectionEnd = Selection.getSelectionEnd(this.SSv);
                if (selectionStart != selectionEnd || keyEvent.isShiftPressed()) {
                    setSelection(selectionStart, Math.max(selectionEnd - 1, 0));
                } else {
                    int max = Math.max(selectionStart - 1, 0);
                    setSelection(max, max);
                }
                AppMethodBeat.o(9953);
                return true;
            } else if (keyEvent.getKeyCode() == 22) {
                int selectionStart2 = Selection.getSelectionStart(this.SSv);
                int selectionEnd2 = Selection.getSelectionEnd(this.SSv);
                if (selectionStart2 != selectionEnd2 || keyEvent.isShiftPressed()) {
                    setSelection(selectionStart2, Math.min(selectionEnd2 + 1, this.SSv.length()));
                } else {
                    int min = Math.min(selectionStart2 + 1, this.SSv.length());
                    setSelection(min, min);
                }
                AppMethodBeat.o(9953);
                return true;
            } else if (keyEvent.getKeyCode() == 19) {
                if (Selection.getSelectionStart(this.SSv) != Selection.getSelectionEnd(this.SSv) || keyEvent.isShiftPressed()) {
                    Selection.extendUp(this.SSv, this.OVt);
                    setSelection(Selection.getSelectionStart(this.SSv), Selection.getSelectionEnd(this.SSv));
                } else {
                    Selection.moveUp(this.SSv, this.OVt);
                    int selectionStart3 = Selection.getSelectionStart(this.SSv);
                    setSelection(selectionStart3, selectionStart3);
                }
                AppMethodBeat.o(9953);
                return true;
            } else if (keyEvent.getKeyCode() == 20) {
                if (Selection.getSelectionStart(this.SSv) != Selection.getSelectionEnd(this.SSv) || keyEvent.isShiftPressed()) {
                    Selection.extendDown(this.SSv, this.OVt);
                    setSelection(Selection.getSelectionStart(this.SSv), Selection.getSelectionEnd(this.SSv));
                } else {
                    Selection.moveDown(this.SSv, this.OVt);
                    int selectionStart4 = Selection.getSelectionStart(this.SSv);
                    setSelection(selectionStart4, selectionStart4);
                }
                AppMethodBeat.o(9953);
                return true;
            } else if ((keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) && (131072 & this.SSw.inputType) == 0) {
                performEditorAction(this.SSw.imeOptions & 255);
                AppMethodBeat.o(9953);
                return true;
            } else {
                int unicodeChar = keyEvent.getUnicodeChar();
                if (unicodeChar != 0) {
                    int max2 = Math.max(0, Selection.getSelectionStart(this.SSv));
                    int max3 = Math.max(0, Selection.getSelectionEnd(this.SSv));
                    int min2 = Math.min(max2, max3);
                    int max4 = Math.max(max2, max3);
                    if (min2 != max4) {
                        this.SSv.delete(min2, max4);
                    }
                    this.SSv.insert(min2, String.valueOf((char) unicodeChar));
                    setSelection(min2 + 1, min2 + 1);
                }
                AppMethodBeat.o(9953);
                return true;
            }
        } else if (keyEvent.getAction() == 1 && (keyEvent.getKeyCode() == 59 || keyEvent.getKeyCode() == 60)) {
            int selectionEnd3 = Selection.getSelectionEnd(this.SSv);
            setSelection(selectionEnd3, selectionEnd3);
            AppMethodBeat.o(9953);
            return true;
        } else {
            AppMethodBeat.o(9953);
            return false;
        }
    }

    public final boolean performContextMenuAction(int i2) {
        AppMethodBeat.i(214897);
        this.SSB = false;
        if (i2 == 16908319) {
            setSelection(0, this.SSv.length());
            AppMethodBeat.o(214897);
            return true;
        } else if (i2 == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.SSv);
            int selectionEnd = Selection.getSelectionEnd(this.SSv);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.yFg.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.SSv.subSequence(min, max)));
                this.SSv.delete(min, max);
                setSelection(min, min);
            }
            AppMethodBeat.o(214897);
            return true;
        } else if (i2 == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.SSv);
            int selectionEnd2 = Selection.getSelectionEnd(this.SSv);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.yFg.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.SSv.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            AppMethodBeat.o(214897);
            return true;
        } else if (i2 == 16908322) {
            ClipData primaryClip = ((ClipboardManager) this.yFg.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null) {
                CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.yFg.getContext());
                int max2 = Math.max(0, Selection.getSelectionStart(this.SSv));
                int max3 = Math.max(0, Selection.getSelectionEnd(this.SSv));
                int min2 = Math.min(max2, max3);
                int max4 = Math.max(max2, max3);
                if (min2 != max4) {
                    this.SSv.delete(min2, max4);
                }
                this.SSv.insert(min2, coerceToText);
                int length = coerceToText.length() + min2;
                setSelection(length, length);
            }
            AppMethodBeat.o(214897);
            return true;
        } else {
            AppMethodBeat.o(214897);
            return false;
        }
    }

    public final boolean performEditorAction(int i2) {
        AppMethodBeat.i(9954);
        this.SSB = false;
        switch (i2) {
            case 0:
                m mVar = this.SOi;
                int i3 = this.SSu;
                io.flutter.a.hwd();
                mVar.bbv.a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i3), "TextInputAction.unspecified"), null);
                break;
            case 1:
                m mVar2 = this.SOi;
                int i4 = this.SSu;
                io.flutter.a.hwd();
                mVar2.bbv.a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i4), "TextInputAction.newline"), null);
                break;
            case 2:
                m mVar3 = this.SOi;
                int i5 = this.SSu;
                io.flutter.a.hwd();
                mVar3.bbv.a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.go"), null);
                break;
            case 3:
                m mVar4 = this.SOi;
                int i6 = this.SSu;
                io.flutter.a.hwd();
                mVar4.bbv.a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i6), "TextInputAction.search"), null);
                break;
            case 4:
                m mVar5 = this.SOi;
                int i7 = this.SSu;
                io.flutter.a.hwd();
                mVar5.bbv.a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i7), "TextInputAction.send"), null);
                break;
            case 5:
                m mVar6 = this.SOi;
                int i8 = this.SSu;
                io.flutter.a.hwd();
                mVar6.bbv.a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i8), "TextInputAction.next"), null);
                break;
            case 6:
            default:
                m mVar7 = this.SOi;
                int i9 = this.SSu;
                io.flutter.a.hwd();
                mVar7.bbv.a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i9), "TextInputAction.done"), null);
                break;
            case 7:
                m mVar8 = this.SOi;
                int i10 = this.SSu;
                io.flutter.a.hwd();
                mVar8.bbv.a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i10), "TextInputAction.previous"), null);
                break;
        }
        AppMethodBeat.o(9954);
        return true;
    }
}
