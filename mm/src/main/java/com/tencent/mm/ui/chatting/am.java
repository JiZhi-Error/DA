package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.base.u;
import com.tencent.tav.core.AssetExtension;
import com.tencent.xweb.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\u0016\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$J\u0016\u0010&\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020 J\u0006\u0010(\u001a\u00020 J\u0006\u0010)\u001a\u00020 R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006+"}, hxF = {"Lcom/tencent/mm/ui/chatting/ScreenProfileReadyUI;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "filePath", "", "fileExt", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "getFileExt", "()Ljava/lang/String;", "setFileExt", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "isShowChangeOrientationTip", "", "pluginControlLayout", "Landroid/widget/RelativeLayout;", "getPluginControlLayout", "()Landroid/widget/RelativeLayout;", "setPluginControlLayout", "(Landroid/widget/RelativeLayout;)V", "profilePluginUi", "Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "getProfilePluginUi", "()Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "setProfilePluginUi", "(Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;)V", "readerContentLayout", "getReaderContentLayout", "setReaderContentLayout", "applyPluginLayout", "", "applyReaderLayout", "checkRatioIsLand", "w", "", "h", "inputFileInfo", "refreshLayout", "showProfileUi", "showRotateScreenInfo", "Companion", "app_release"})
public final class am extends FrameLayout {
    public static final a Pks = new a((byte) 0);
    public RelativeLayout Pko = ((RelativeLayout) findViewById(R.id.hbw));
    private RelativeLayout Pkp = ((RelativeLayout) findViewById(R.id.hbz));
    private ag Pkq = new ag(this.filePath, (byte) 0);
    private boolean Pkr;
    public String filePath;
    public String gCr;

    static {
        AppMethodBeat.i(231186);
        AppMethodBeat.o(231186);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue", "(Ljava/lang/Integer;)V"})
    public static final class c<T> implements ValueCallback<Integer> {
        final /* synthetic */ am Pkt;

        public c(am amVar) {
            this.Pkt = amVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Integer num) {
            AppMethodBeat.i(231180);
            Integer num2 = num;
            if (num2 == null || num2.intValue() != 0) {
                u.cH(this.Pkt.getContext(), this.Pkt.getContext().getString(R.string.gey));
                ac.eom().emx();
            }
            AppMethodBeat.o(231180);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/chatting/ScreenProfileReadyUI$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public am(Context context, String str, String str2) {
        super(context);
        p.h(context, "context");
        p.h(str, "filePath");
        p.h(str2, "fileExt");
        AppMethodBeat.i(231185);
        this.filePath = str;
        this.gCr = str2;
        LayoutInflater.from(context).inflate(R.layout.bog, this);
        gOo();
        gOn();
        AppMethodBeat.o(231185);
    }

    public final String getFileExt() {
        return this.gCr;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final void setFileExt(String str) {
        AppMethodBeat.i(231184);
        p.h(str, "<set-?>");
        this.gCr = str;
        AppMethodBeat.o(231184);
    }

    public final void setFilePath(String str) {
        AppMethodBeat.i(231183);
        p.h(str, "<set-?>");
        this.filePath = str;
        AppMethodBeat.o(231183);
    }

    public final RelativeLayout getReaderContentLayout() {
        return this.Pko;
    }

    public final void setReaderContentLayout(RelativeLayout relativeLayout) {
        this.Pko = relativeLayout;
    }

    public final RelativeLayout getPluginControlLayout() {
        return this.Pkp;
    }

    public final void setPluginControlLayout(RelativeLayout relativeLayout) {
        this.Pkp = relativeLayout;
    }

    public final ag getProfilePluginUi() {
        return this.Pkq;
    }

    public final void setProfilePluginUi(ag agVar) {
        this.Pkq = agVar;
    }

    public final void gOn() {
        ViewGroup.LayoutParams layoutParams;
        AppMethodBeat.i(231181);
        RelativeLayout relativeLayout = this.Pko;
        if (relativeLayout == null || (layoutParams = relativeLayout.getLayoutParams()) == null) {
            AppMethodBeat.o(231181);
        } else if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(231181);
            throw tVar;
        } else {
            k.a aVar = k.zTz;
            Context context = getContext();
            p.g(context, "context");
            if (k.a.gE(context) != 90) {
                k.a aVar2 = k.zTz;
                Context context2 = getContext();
                p.g(context2, "context");
                if (k.a.gE(context2) != 270) {
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = f.zSE;
                    ((RelativeLayout.LayoutParams) layoutParams).setMarginEnd(0);
                    AppMethodBeat.o(231181);
                    return;
                }
            }
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
            ((RelativeLayout.LayoutParams) layoutParams).setMarginEnd(f.zSE);
            AppMethodBeat.o(231181);
        }
    }

    public final void gOo() {
        AppMethodBeat.i(231182);
        RelativeLayout relativeLayout = this.Pkp;
        if (relativeLayout != null) {
            RelativeLayout relativeLayout2 = this.Pkp;
            if (relativeLayout2 != null) {
                relativeLayout2.removeAllViews();
            }
            k.a aVar = k.zTz;
            Context context = getContext();
            p.g(context, "context");
            if (k.a.gE(context) != 90) {
                k.a aVar2 = k.zTz;
                Context context2 = getContext();
                p.g(context2, "context");
                if (k.a.gE(context2) != 270) {
                    ag agVar = this.Pkq;
                    if (agVar != null) {
                        Context context3 = getContext();
                        p.g(context3, "context");
                        agVar.f(context3, relativeLayout);
                        AppMethodBeat.o(231182);
                        return;
                    }
                    AppMethodBeat.o(231182);
                    return;
                }
            }
            ag agVar2 = this.Pkq;
            if (agVar2 != null) {
                Context context4 = getContext();
                p.g(context4, "context");
                agVar2.g(context4, relativeLayout);
                AppMethodBeat.o(231182);
                return;
            }
            AppMethodBeat.o(231182);
            return;
        }
        AppMethodBeat.o(231182);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J8\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0016¨\u0006\u001c"}, hxF = {"com/tencent/mm/ui/chatting/ScreenProfileReadyUI$inputFileInfo$1", "Lcom/tencent/xweb/FileReaderXWeb$ActionCallback;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onPageChange", "pageIndex", "", "pageWidth", "pageHeight", "onPageCountUpdate", "totalCount", "onReachEnd", "onSingleTap", "onThumbnailLoad", AssetExtension.SCENE_THUMBNAIL, "Landroid/graphics/Bitmap;", "onUserCancel", "onUserOperated", "onViewStatusChange", FirebaseAnalytics.b.INDEX, "zoom", "", "curWidth", "curHeight", "transX", "transY", "app_release"})
    public static final class b implements h.a {
        final /* synthetic */ am Pkt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b(am amVar) {
            this.Pkt = amVar;
        }

        @Override // com.tencent.xweb.h.a
        public final void Rz(int i2) {
            AppMethodBeat.i(231176);
            Log.i("MicroMsg.ScreenProfileReadyUI", "xfile onPageCountUpdate ".concat(String.valueOf(i2)));
            ag profilePluginUi = this.Pkt.getProfilePluginUi();
            if (profilePluginUi != null) {
                profilePluginUi.maxCount = i2;
            }
            ag profilePluginUi2 = this.Pkt.getProfilePluginUi();
            if (profilePluginUi2 != null) {
                profilePluginUi2.gJA();
                AppMethodBeat.o(231176);
                return;
            }
            AppMethodBeat.o(231176);
        }

        @Override // com.tencent.xweb.h.a
        public final void cTA() {
            AppMethodBeat.i(231177);
            Log.i("MicroMsg.ScreenProfileReadyUI", "xfile on user cancel finish");
            AppMethodBeat.o(231177);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x007d, code lost:
            if (com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.b.gE(r0) == 180) goto L_0x007f;
         */
        @Override // com.tencent.xweb.h.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void ar(int r5, int r6, int r7) {
            /*
            // Method dump skipped, instructions count: 169
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.am.b.ar(int, int, int):void");
        }

        @Override // com.tencent.xweb.h.a
        public final void b(int i2, float f2, int i3, int i4, int i5, int i6) {
        }

        @Override // com.tencent.xweb.h.a
        public final void c(int i2, Bitmap bitmap) {
            AppMethodBeat.i(231179);
            p.h(bitmap, AssetExtension.SCENE_THUMBNAIL);
            Log.i("MicroMsg.ScreenProfileReadyUI", "xfile onThumbnailLoad ".concat(String.valueOf(i2)));
            AppMethodBeat.o(231179);
        }

        @Override // com.tencent.xweb.h.a
        public final void epu() {
        }

        @Override // com.tencent.xweb.h.a
        public final void epv() {
        }

        @Override // com.tencent.xweb.h.a
        public final void epw() {
        }
    }

    public static boolean lg(int i2, int i3) {
        return ((float) i2) / ((float) i3) >= 1.3333334f;
    }
}
