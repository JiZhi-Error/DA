package com.tencent.mm.plugin.vlog.ui.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.TextColorSelector;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002&'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R#\u0010\u001b\u001a\n \r*\u0004\u0018\u00010\u001c0\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u001d\u0010\u001eR#\u0010 \u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b!\u0010\u000f¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker;", "", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;)V", "callback", "Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;)V", "closeBtn", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCloseBtn", "()Landroid/widget/ImageView;", "closeBtn$delegate", "Lkotlin/Lazy;", "colorList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "getColorList", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "colorList$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "isInit", "", "panelRoot", "Landroid/view/View;", "getPanelRoot", "()Landroid/view/View;", "panelRoot$delegate", "undoBtn", "getUndoBtn", "undoBtn$delegate", "checkInit", "", "updateSelect", "ColorPickerCallback", "Companion", "plugin-vlog_release"})
public final class a {
    public static final int[] GQw = {-1, WebView.NIGHT_MODE_COLOR, -707825, -17592, -16535286, -15172610, -7054596};
    public static final b GQx = new b((byte) 0);
    private final kotlin.f GGj = kotlin.g.ah(new h(this));
    private final kotlin.f GQt = kotlin.g.ah(new g(this));
    public final kotlin.f GQu = kotlin.g.ah(new i(this));
    public AbstractC1884a GQv;
    public boolean isInit;
    public final kotlin.f vLW = kotlin.g.ah(new f(this));
    public final EditorPanelHolder wji;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$ColorPickerCallback;", "", "onClose", "", "onSelectColor", FirebaseAnalytics.b.INDEX, "", "onUndo", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.widget.a$a  reason: collision with other inner class name */
    public interface AbstractC1884a {
        void XT();

        void acC(int i2);

        void onClose();
    }

    public final View fDm() {
        AppMethodBeat.i(192208);
        View view = (View) this.GGj.getValue();
        AppMethodBeat.o(192208);
        return view;
    }

    public final TextColorSelector fEz() {
        AppMethodBeat.i(192209);
        TextColorSelector textColorSelector = (TextColorSelector) this.GQt.getValue();
        AppMethodBeat.o(192209);
        return textColorSelector;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ a GQy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar) {
            super(1);
            this.GQy = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(192201);
            int intValue = num.intValue();
            AbstractC1884a aVar = this.GQy.GQv;
            if (aVar != null) {
                aVar.acC(intValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(192201);
            return xVar;
        }
    }

    public a(EditorPanelHolder editorPanelHolder) {
        p.h(editorPanelHolder, "holder");
        AppMethodBeat.i(192210);
        this.wji = editorPanelHolder;
        AppMethodBeat.o(192210);
    }

    public static final /* synthetic */ View a(a aVar) {
        AppMethodBeat.i(192212);
        View fDm = aVar.fDm();
        AppMethodBeat.o(192212);
        return fDm;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$Companion;", "", "()V", "COLOR_0", "", "COLOR_1", "COLOR_2", "COLOR_3", "COLOR_4", "COLOR_5", "COLOR_6", "ColorList", "", "getColorList", "()[I", "plugin-vlog_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(192211);
        AppMethodBeat.o(192211);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ a GQy;

        public d(a aVar) {
            this.GQy = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(192202);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            AbstractC1884a aVar = this.GQy.GQv;
            if (aVar != null) {
                aVar.XT();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(192202);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ a GQy;

        public e(a aVar) {
            this.GQy = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(192203);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            AbstractC1884a aVar = this.GQy.GQv;
            if (aVar != null) {
                aVar.onClose();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/widget/PhotoEditColorPicker$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(192203);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ a GQy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(a aVar) {
            super(0);
            this.GQy = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(192206);
            View inflate = LayoutInflater.from(this.GQy.wji.getContext()).inflate(R.layout.a14, (ViewGroup) this.GQy.wji, false);
            EditorPanelHolder editorPanelHolder = this.GQy.wji;
            p.g(inflate, LocaleUtil.ITALIAN);
            EditorPanelHolder.a(editorPanelHolder, inflate);
            AppMethodBeat.o(192206);
            return inflate;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends q implements kotlin.g.a.a<TextColorSelector> {
        final /* synthetic */ a GQy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(a aVar) {
            super(0);
            this.GQy = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextColorSelector invoke() {
            AppMethodBeat.i(192205);
            TextColorSelector textColorSelector = (TextColorSelector) a.a(this.GQy).findViewById(R.id.b80);
            AppMethodBeat.o(192205);
            return textColorSelector;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ a GQy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(a aVar) {
            super(0);
            this.GQy = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(192207);
            ImageView imageView = (ImageView) a.a(this.GQy).findViewById(R.id.gu0);
            AppMethodBeat.o(192207);
            return imageView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ a GQy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar) {
            super(0);
            this.GQy = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(192204);
            ImageView imageView = (ImageView) a.a(this.GQy).findViewById(R.id.bx9);
            AppMethodBeat.o(192204);
            return imageView;
        }
    }
}
