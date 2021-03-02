package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0002:;B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010&\u001a\u00020\n2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0(J\u0006\u0010)\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\nJ\u0018\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/H\u0016J\u0006\u00100\u001a\u00020\nJ\u0006\u00101\u001a\u00020\nJ\u0006\u00102\u001a\u00020\nJ\u000e\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\u001fJ\u000e\u00105\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u000207H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\\\u0010\u0019\u001aD\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012#\u0012!\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\n\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "cancelClickListener", "Lkotlin/Function0;", "", "getCancelClickListener", "()Lkotlin/jvm/functions/Function0;", "setCancelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "captionType", "", "captionView", "Landroid/support/v7/widget/RecyclerView;", "currentPos", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "repeat", "showIm", "Ljava/lang/Runnable;", "sureClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "result", "getSureClickListener", "()Lkotlin/jvm/functions/Function2;", "setSureClickListener", "(Lkotlin/jvm/functions/Function2;)V", "addCaptionItemData", "items", "", "clearCaptionData", "hideInput", "notifyDataSetChanged", "onKeyboardHeightChanged", "height", "isResized", "", "pause", "release", "resume", "selectCaption", "transResult", "selectType", "delay", "", "time2Pos", "timeStampMs", "Companion", "EditorCaptionAdapter", "plugin-vlog_release"})
public final class c extends LinearLayout implements g {
    @Deprecated
    public static final a GKw = new a((byte) 0);
    int GKp;
    private RecyclerView GKq;
    b GKr;
    private m<? super Integer, ? super ArrayList<sy>, x> GKs;
    private kotlin.g.a.a<x> GKt;
    private int GKu;
    private final Runnable GKv;
    private int ady;
    h gyh;

    static {
        AppMethodBeat.i(191661);
        AppMethodBeat.o(191661);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(191660);
        this.GKr = new b(context);
        this.gyh = new h((Activity) context);
        LayoutInflater.from(context).inflate(R.layout.a0q, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.fh);
        setOrientation(1);
        View findViewById = findViewById(R.id.ait);
        p.g(findViewById, "findViewById(R.id.caption_list)");
        this.GKq = (RecyclerView) findViewById;
        findViewById(R.id.aim).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.c.AnonymousClass1 */
            final /* synthetic */ c GKx;

            {
                this.GKx = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191644);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a<x> cancelClickListener = this.GKx.getCancelClickListener();
                if (cancelClickListener != null) {
                    cancelClickListener.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191644);
            }
        });
        findViewById(R.id.aj1).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.c.AnonymousClass2 */
            final /* synthetic */ c GKx;

            {
                this.GKx = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191645);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m<Integer, ArrayList<sy>, x> sureClickListener = this.GKx.getSureClickListener();
                if (sureClickListener != null) {
                    sureClickListener.invoke(Integer.valueOf(this.GKx.GKp), this.GKx.GKr.GKy);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191645);
            }
        });
        this.GKq.setLayoutManager(new EditorCaptionLayoutManager(context));
        this.GKq.setAdapter(this.GKr);
        this.gyh.setKeyboardHeightObserver(this);
        this.GKv = new RunnableC1866c(this, context);
        AppMethodBeat.o(191660);
    }

    public static final /* synthetic */ void f(c cVar) {
        AppMethodBeat.i(191662);
        cVar.Le(50);
        AppMethodBeat.o(191662);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.Integer, ? super java.util.ArrayList<com.tencent.mm.protocal.protobuf.sy>, kotlin.x>, kotlin.g.a.m<java.lang.Integer, java.util.ArrayList<com.tencent.mm.protocal.protobuf.sy>, kotlin.x> */
    public final m<Integer, ArrayList<sy>, x> getSureClickListener() {
        return this.GKs;
    }

    public final void setSureClickListener(m<? super Integer, ? super ArrayList<sy>, x> mVar) {
        this.GKs = mVar;
    }

    public final kotlin.g.a.a<x> getCancelClickListener() {
        return this.GKt;
    }

    public final void setCancelClickListener(kotlin.g.a.a<x> aVar) {
        this.GKt = aVar;
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        AppMethodBeat.i(191654);
        Log.i("MicroMsg.EditorEditCaptionView", "onKeyboardHeightChanged, height:" + i2 + ", isResized:" + z);
        if (getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(191654);
                throw tVar;
            }
            ((FrameLayout.LayoutParams) layoutParams).bottomMargin = i2;
            setLayoutParams(getLayoutParams());
        }
        AppMethodBeat.o(191654);
    }

    public final void fDV() {
        AppMethodBeat.i(191655);
        this.GKr.GKy.clear();
        AppMethodBeat.o(191655);
    }

    public final void hU(List<? extends sy> list) {
        AppMethodBeat.i(191656);
        p.h(list, "items");
        this.GKr.GKy.addAll(list);
        AppMethodBeat.o(191656);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.caption.c$c  reason: collision with other inner class name */
    static final class RunnableC1866c implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ c GKx;

        RunnableC1866c(c cVar, Context context) {
            this.GKx = cVar;
            this.$context = context;
        }

        public final void run() {
            AppMethodBeat.i(191653);
            RecyclerView.LayoutManager layoutManager = this.GKx.GKq.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(191653);
                throw tVar;
            }
            View findViewByPosition = ((LinearLayoutManager) layoutManager).findViewByPosition(this.GKx.ady);
            MMEditText mMEditText = findViewByPosition != null ? (MMEditText) findViewByPosition.findViewById(R.id.aio) : null;
            if (mMEditText != null) {
                mMEditText.requestFocus();
            }
            if (mMEditText != null) {
                mMEditText.setSelection(mMEditText.getText().length());
            }
            this.GKx.GKu++;
            a unused = c.GKw;
            Log.i("MicroMsg.EditorEditCaptionView", "repeat " + this.GKx.GKu);
            InputMethodManager inputMethodManager = (InputMethodManager) this.$context.getSystemService("input_method");
            if (inputMethodManager != null && !inputMethodManager.showSoftInput(mMEditText, 0) && this.GKx.GKu < 5) {
                c.f(this.GKx);
            }
            AppMethodBeat.o(191653);
        }
    }

    public final void a(sy syVar) {
        AppMethodBeat.i(191657);
        p.h(syVar, "transResult");
        this.GKu = 0;
        int Lf = Lf(syVar.LaT);
        Log.i("MicroMsg.EditorEditCaptionView", "scrollToTimeMs " + syVar.LaT + ' ' + this.ady);
        RecyclerView.LayoutManager layoutManager = this.GKq.getLayoutManager();
        if (layoutManager != null) {
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Lf, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(layoutManager, a2.axQ(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
            layoutManager.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(layoutManager, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
        }
        Le(0);
        AppMethodBeat.o(191657);
    }

    private final void Le(long j2) {
        AppMethodBeat.i(191658);
        com.tencent.f.h.RTc.n(this.GKv, j2);
        AppMethodBeat.o(191658);
    }

    private final int Lf(long j2) {
        AppMethodBeat.i(191659);
        int i2 = 0;
        for (T t : this.GKr.GKy) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            if (t.LaT == j2) {
                this.ady = i2;
                i2 = i3;
            } else {
                i2 = i3;
            }
        }
        int i4 = this.ady;
        AppMethodBeat.o(191659);
        return i4;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0018\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0016R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getCaptionItems", "()Ljava/util/ArrayList;", "setCaptionItems", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "currentPos", "", "getCurrentPos", "()I", "setCurrentPos", "(I)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1;", "getItemCount", "getString", "", "byte", "Lcom/tencent/mm/protobuf/ByteString;", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
    public static final class b extends RecyclerView.a<RecyclerView.v> {
        ArrayList<sy> GKy = new ArrayList<>();
        private final a GKz = new a(this);
        private Context context;

        public b(Context context2) {
            p.h(context2, "context");
            AppMethodBeat.i(191652);
            this.context = context2;
            AppMethodBeat.o(191652);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J*\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$listener$1", "Landroid/text/TextWatcher;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "plugin-vlog_release"})
        public static final class a implements TextWatcher {
            final /* synthetic */ b GKA;
            int position;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(b bVar) {
                this.GKA = bVar;
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(191646);
                if (editable != null) {
                    sy syVar = this.GKA.GKy.get(this.position);
                    String obj = editable.toString();
                    Charset charset = d.UTF_8;
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(191646);
                        throw tVar;
                    }
                    byte[] bytes = obj.getBytes(charset);
                    p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                    syVar.LaS = new com.tencent.mm.bw.b(bytes);
                }
                AppMethodBeat.o(191646);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView$EditorCaptionAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-vlog_release"})
        /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.caption.c$b$c  reason: collision with other inner class name */
        public static final class C1865c extends RecyclerView.v {
            final /* synthetic */ ViewGroup GKC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1865c(ViewGroup viewGroup, View view) {
                super(view);
                this.GKC = viewGroup;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(191648);
            p.h(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.a0p, viewGroup, false);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(191648);
                throw tVar;
            }
            ViewGroup viewGroup2 = (ViewGroup) inflate;
            C1865c cVar = new C1865c(viewGroup2, viewGroup2);
            AppMethodBeat.o(191648);
            return cVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(191649);
            int size = this.GKy.size();
            AppMethodBeat.o(191649);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(191650);
            p.h(vVar, "viewHolder");
            View view = vVar.aus;
            p.g(view, "viewHolder.itemView");
            sy syVar = this.GKy.get(i2);
            p.g(syVar, "captionItems[position]");
            sy syVar2 = syVar;
            if (syVar2.LaV || TextUtils.isEmpty(d(syVar2.LaS))) {
                view.setVisibility(4);
                AppMethodBeat.o(191650);
                return;
            }
            view.setVisibility(0);
            MMEditText mMEditText = (MMEditText) view.findViewById(R.id.aio);
            mMEditText.setOnFocusChangeListener(new View$OnFocusChangeListenerC1864b(this, i2, mMEditText));
            mMEditText.setText(d(this.GKy.get(i2).LaS));
            AppMethodBeat.o(191650);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
        /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.caption.c$b$b  reason: collision with other inner class name */
        static final class View$OnFocusChangeListenerC1864b implements View.OnFocusChangeListener {
            final /* synthetic */ b GKA;
            final /* synthetic */ MMEditText GKB;
            final /* synthetic */ int gUj;

            View$OnFocusChangeListenerC1864b(b bVar, int i2, MMEditText mMEditText) {
                this.GKA = bVar;
                this.gUj = i2;
                this.GKB = mMEditText;
            }

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(191647);
                if (z) {
                    this.GKA.GKz.position = this.gUj;
                    this.GKB.addTextChangedListener(this.GKA.GKz);
                    AppMethodBeat.o(191647);
                    return;
                }
                this.GKB.removeTextChangedListener(this.GKA.GKz);
                AppMethodBeat.o(191647);
            }
        }

        private static String d(com.tencent.mm.bw.b bVar) {
            AppMethodBeat.i(191651);
            if (bVar == null) {
                AppMethodBeat.o(191651);
                return "";
            }
            String bVar2 = bVar.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            p.g(bVar2, "byte.toString(\"UTF-8\")");
            AppMethodBeat.o(191651);
            return bVar2;
        }
    }
}
