package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 62\u00020\u00012\u00020\u00022\u00020\u0003:\u00016B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ,\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0010J\b\u0010$\u001a\u00020\u001aH\u0002J\n\u0010%\u001a\u0004\u0018\u00010!H\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\u0012\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001f\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001eH\u0016J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001eH\u0016J\u0006\u00102\u001a\u00020\u001aJ*\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u0002052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "inputPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;)V", "addTextBtn", "Landroid/widget/ImageView;", ShareConstants.FEED_CAPTION_PARAM, "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "changeText", "", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "editText", "", "text", "", "color", "", "bgColor", "font", "", "enableSelectFont", "enable", "initSafeArea", "name", "onBackPress", "onClick", "v", "Landroid/view/View;", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "resetIconColor", "iconColor", "setVisibility", "visibility", "showEditTextPanel", "updateCaption", "transResult", "", "Companion", "plugin-recordvideo_release"})
public final class c implements View.OnClickListener, t {
    @Deprecated
    public static final a BPZ = new a((byte) 0);
    private final ImageView BPV;
    private boolean BPW;
    private final sy BPX = new sy();
    private EditorInputView BPY;
    private ViewGroup parent;
    d wgr;

    static {
        AppMethodBeat.i(237275);
        AppMethodBeat.o(237275);
    }

    public c(ViewGroup viewGroup, d dVar, EditorInputView editorInputView) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        p.h(editorInputView, "inputPanel");
        AppMethodBeat.i(75473);
        this.parent = viewGroup;
        this.wgr = dVar;
        this.BPY = editorInputView;
        View findViewById = this.parent.findViewById(R.id.bwv);
        p.g(findViewById, "parent.findViewById(R.id.editor_add_text)");
        this.BPV = (ImageView) findViewById;
        this.BPV.setImageDrawable(ar.m(this.parent.getContext(), R.raw.icons_filled_text, -1));
        this.BPV.setOnClickListener(this);
        this.BPY.setConfirmBtnBg(R.drawable.axi);
        this.BPY.setOnVisibleChangeCallback(new b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.c.AnonymousClass1 */
            final /* synthetic */ c BQa;

            {
                this.BQa = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(75465);
                if (bool.booleanValue()) {
                    d.b.a(this.BQa.wgr, d.c.BUU);
                } else {
                    d.b.a(this.BQa.wgr, d.c.BVj);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(75465);
                return xVar;
            }
        });
        this.BPY.setTextCallback(new EditorInputView.a(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.c.AnonymousClass2 */
            final /* synthetic */ c BQa;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.BQa = r1;
            }

            @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.a
            public final void b(CharSequence charSequence, int i2, int i3, String str) {
                AppMethodBeat.i(237268);
                p.h(str, "font");
                if (charSequence != null) {
                    if (!(charSequence.length() == 0)) {
                        Bundle bundle = new Bundle();
                        switch (this.BQa.BPY.getMode()) {
                            case 0:
                                bundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", charSequence);
                                bundle.putInt("PARAM_EDIT_TEXT_COLOR", i2);
                                bundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", i3);
                                bundle.putString("PARAM_EDIT_TEXT_FONT", str);
                                this.BQa.wgr.a(d.c.BUY, bundle);
                                break;
                            case 2:
                                sy syVar = this.BQa.BPX;
                                String obj = charSequence.toString();
                                Charset charset = kotlin.n.d.UTF_8;
                                if (obj != null) {
                                    byte[] bytes = obj.getBytes(charset);
                                    p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                                    syVar.LaS = new com.tencent.mm.bw.b(bytes);
                                    bundle.putByteArray("PARAM_1_BYTEARRAY", this.BQa.BPX.toByteArray());
                                    bundle.putLong("PARAM_1_LONG", this.BQa.BPX.LaT);
                                    bundle.putInt("PARAM_EDIT_TEXT_COLOR", i2);
                                    bundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", i3);
                                    bundle.putString("PARAM_EDIT_TEXT_FONT", str);
                                    this.BQa.wgr.a(d.c.BWs, bundle);
                                    break;
                                } else {
                                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                                    AppMethodBeat.o(237268);
                                    throw tVar;
                                }
                        }
                        this.BQa.BPY.setShow(false);
                        AppMethodBeat.o(237268);
                        return;
                    }
                }
                this.BQa.BPY.setShow(false);
                AppMethodBeat.o(237268);
            }

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.a
            public final void onCancel() {
                AppMethodBeat.i(75467);
                this.BQa.BPY.setShow(false);
                switch (this.BQa.BPY.getMode()) {
                    case 0:
                        d.b.a(this.BQa.wgr, d.c.BVs);
                        d.b.a(this.BQa.wgr, d.c.BVa);
                        break;
                    case 2:
                        d.b.a(this.BQa.wgr, d.c.BWu);
                        AppMethodBeat.o(75467);
                        return;
                }
                AppMethodBeat.o(75467);
            }
        });
        Point az = au.az(this.parent.getContext());
        int i2 = az.y;
        int i3 = az.x;
        float f2 = ((float) i2) / ((float) i3);
        float f3 = (((float) i3) - (((float) i2) / 2.18f)) / 2.0f;
        if (f2 <= 1.78f || f2 < 2.18f) {
            this.BPY.bL(f3);
        }
        AppMethodBeat.o(75473);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237276);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237276);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static /* synthetic */ void a(c cVar, CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(237270);
        cVar.a(charSequence, i2, i3, "");
        AppMethodBeat.o(237270);
    }

    public final void a(CharSequence charSequence, int i2, int i3, String str) {
        AppMethodBeat.i(237269);
        this.BPW = true;
        this.BPY.mode = 0;
        this.BPY.setShow(true);
        this.BPY.setTypeFace(str);
        this.BPY.g(charSequence, i2, i3);
        AppMethodBeat.o(237269);
    }

    public final void a(byte[] bArr, int i2, int i3, String str) {
        AppMethodBeat.i(237271);
        p.h(bArr, "transResult");
        try {
            sy syVar = new sy();
            try {
                syVar.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                syVar = null;
            }
            sy syVar2 = syVar;
            if (syVar2 != null) {
                this.BPW = true;
                this.BPX.id = syVar2.id;
                this.BPX.LaS = syVar2.LaS;
                this.BPX.LaT = syVar2.LaT;
                this.BPX.LaU = syVar2.LaU;
                this.BPY.mode = 2;
                this.BPY.setShow(true);
                this.BPY.setTypeFace(str);
                this.BPY.g(syVar2.LaS.yO(), i2, i3);
                AppMethodBeat.o(237271);
                return;
            }
            AppMethodBeat.o(237271);
        } catch (IOException e3) {
            com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.EditAddTextPlugin", e3, "", new Object[0]);
            AppMethodBeat.o(237271);
        }
    }

    public final void a(Integer num, Integer num2) {
        AppMethodBeat.i(75469);
        View confirm = this.BPY.getConfirm();
        if (!(num == null || num.intValue() == 0)) {
            confirm.setBackgroundResource(num.intValue());
        }
        if (!(num2 == null || num2.intValue() == 0 || !(confirm instanceof TextView))) {
            ((TextView) confirm).setTextColor(android.support.v4.content.b.n(((TextView) confirm).getContext(), num2.intValue()));
        }
        AppMethodBeat.o(75469);
    }

    public final void eKo() {
        AppMethodBeat.i(237272);
        View findViewById = this.BPY.findViewById(R.id.bxb);
        p.g(findViewById, "findViewById<View>(R.id.editor_input_font)");
        findViewById.setVisibility(0);
        AppMethodBeat.o(237272);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(75470);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        this.BPY.mode = 0;
        this.BPY.setShow(true);
        EditorInputView.c cVar = EditorInputView.Cdg;
        this.BPY.g("", EditorInputView.Cdc, 0);
        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_TEXT_COUNT_INT");
        com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VH(5);
        com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VI(8);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75470);
    }

    public final void eKp() {
        AppMethodBeat.i(237273);
        this.BPV.performClick();
        AppMethodBeat.o(237273);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75471);
        this.BPV.setVisibility(i2);
        AppMethodBeat.o(75471);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(75472);
        if (this.BPY.bJw()) {
            this.BPY.cancel();
            this.BPY.setShow(false);
            AppMethodBeat.o(75472);
            return true;
        }
        AppMethodBeat.o(75472);
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return "plugin_text";
    }

    public final void VC(int i2) {
        AppMethodBeat.i(237274);
        this.BPV.setImageDrawable(ar.m(this.parent.getContext(), R.raw.icons_filled_text, i2));
        AppMethodBeat.o(237274);
    }
}
