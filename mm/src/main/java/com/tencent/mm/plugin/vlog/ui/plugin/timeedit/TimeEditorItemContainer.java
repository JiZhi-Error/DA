package com.tencent.mm.plugin.vlog.ui.plugin.timeedit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.n;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000û\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0001E\u0018\u0000 ¦\u00012\u00020\u00012\u00020\u0002:\u0002¦\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010e\u001a\u00020\"2\u0006\u0010f\u001a\u00020\u001eH\u0002J\u000e\u0010g\u001a\u00020\"2\u0006\u0010h\u001a\u00020HJ\u0018\u0010i\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u00172\u0006\u0010j\u001a\u00020kH\u0002J\u0012\u0010l\u001a\u00020\u001e2\b\u0010m\u001a\u0004\u0018\u00010kH\u0016J\u000e\u0010n\u001a\u00020\"2\u0006\u0010o\u001a\u00020\u001eJ\f\u0010p\u001a\b\u0012\u0004\u0012\u00020H0qJ\f\u0010r\u001a\b\u0012\u0004\u0012\u00020s0qJ\u001e\u0010t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020M0u0qJ\b\u0010v\u001a\u00020\u001aH\u0002J\b\u0010w\u001a\u00020\u001aH\u0002J\u0016\u0010x\u001a\u0012\u0012\u0004\u0012\u00020H0yj\b\u0012\u0004\u0012\u00020H`zJ\u001e\u0010{\u001a\u0012\u0012\u0004\u0012\u00020|0yj\b\u0012\u0004\u0012\u00020|`z2\u0006\u0010}\u001a\u00020\u001aJ\u000e\u0010~\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\u001a\u00020\"2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J\u001b\u0010\u0001\u001a\u00020\"2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020\nH\u0016J\t\u0010\u0001\u001a\u00020\"H\u0016J\u0012\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020MH\u0016J-\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0014J\u0015\u0010\u0001\u001a\u00020\"2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0011\u0010\u0001\u001a\u00020\u001e2\u0006\u0010j\u001a\u00020kH\u0016J\u0007\u0010\u0001\u001a\u00020\"J\u0011\u0010\u0001\u001a\u00020\"2\b\u0010\u0001\u001a\u00030\u0001J\u001a\u0010\u0001\u001a\u00020\"2\b\u0010>\u001a\u0004\u0018\u00010\u00172\u0007\u0010\u0001\u001a\u00020\u001eJ\u0010\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\u001eJ\u0007\u0010\u0001\u001a\u00020\"J\u0007\u0010\u0001\u001a\u00020\"J\u000f\u0010\u0001\u001a\u00020\"2\u0006\u0010o\u001a\u00020\u001eJ\u0007\u0010\u0001\u001a\u00020\"J\u000f\u0010\u0001\u001a\u00020\"2\u0006\u0010}\u001a\u00020\u001aJ\u001e\u0010\u0001\u001a\u00020\"2\b\u0010T\u001a\u0004\u0018\u00010\u00172\t\b\u0002\u0010 \u0001\u001a\u00020\u001eH\u0002J\u0011\u0010¡\u0001\u001a\u00020\"2\u0006\u0010`\u001a\u00020\u001eH\u0002J\u0007\u0010¢\u0001\u001a\u00020\"J\u000f\u0010£\u0001\u001a\u00020\"2\u0006\u0010h\u001a\u00020HJ\u0010\u0010¤\u0001\u001a\u00020\"2\u0007\u0010¥\u0001\u001a\u00020:R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0004¢\u0006\u0002\n\u0000R7\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R#\u0010'\u001a\n )*\u0004\u0018\u00010(0(8BX\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R#\u0010.\u001a\n )*\u0004\u0018\u00010/0/8BX\u0002¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b0\u00101R#\u00103\u001a\n )*\u0004\u0018\u000104048BX\u0002¢\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b5\u00106R\u0010\u00108\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R9\u0010=\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R#\u0010A\u001a\n )*\u0004\u0018\u00010/0/8BX\u0002¢\u0006\f\n\u0004\bC\u0010-\u001a\u0004\bB\u00101R\u0010\u0010D\u001a\u00020EX\u0004¢\u0006\u0004\n\u0002\u0010FR9\u0010G\u001a!\u0012\u0015\u0012\u0013\u0018\u00010H¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010$\"\u0004\bK\u0010&R\u001a\u0010L\u001a\u00020MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR7\u0010R\u001a\u001f\u0012\u0013\u0012\u00110S¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(T\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010$\"\u0004\bV\u0010&R9\u0010W\u001a!\u0012\u0015\u0012\u0013\u0018\u00010H¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010$\"\u0004\bY\u0010&R\u001b\u0010Z\u001a\u00020[8BX\u0002¢\u0006\f\n\u0004\b^\u0010-\u001a\u0004\b\\\u0010]R7\u0010_\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(`\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010$\"\u0004\bb\u0010&R\u000e\u0010c\u001a\u00020dX\u0004¢\u0006\u0002\n\u0000¨\u0006§\u0001"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditorItemContainer;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clearActive", "Ljava/lang/Runnable;", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "currActiveItem", "Landroid/view/View;", "deleteCheckDialog", "Lkotlin/Function2;", "", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDeleteView", "()Landroid/widget/TextView;", "deleteView$delegate", "Lkotlin/Lazy;", "deleteViewGroup", "Landroid/view/ViewGroup;", "getDeleteViewGroup", "()Landroid/view/ViewGroup;", "deleteViewGroup$delegate", "deleteViewIcon", "Landroid/widget/ImageView;", "getDeleteViewIcon", "()Landroid/widget/ImageView;", "deleteViewIcon$delegate", "deletingItem", "displayArea", "Landroid/graphics/Rect;", "enableTouch", "forceStaticImage", "itemChangeListener", "itemView", "getItemChangeListener", "setItemChangeListener", "itemLayout", "getItemLayout", "itemLayout$delegate", "itemStateResolve", "com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditorItemContainer$itemStateResolve$1;", "readTextListener", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "editData", "getReadTextListener", "setReadTextListener", "segmentOffset", "", "getSegmentOffset", "()J", "setSegmentOffset", "(J)V", "showCaptionDialogListener", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "view", "getShowCaptionDialogListener", "setShowCaptionDialogListener", "timeEditClickListener", "getTimeEditClickListener", "setTimeEditClickListener", "timeEditIcon", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView;", "getTimeEditIcon", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView;", "timeEditIcon$delegate", "timeEditMenuChangeListener", "show", "getTimeEditMenuChangeListener", "setTimeEditMenuChangeListener", "viewParser", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditViewParser;", "activeDeleteView", "active", "addTimeEditorInfo", "info", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "enableGif", "enable", "getAllEditorData", "", "getAllItemViews", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "getAllTTSData", "Lkotlin/Triple;", "getDialogMenu", "getDialogTitle", "getEditorDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getObjectIdEditItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "objectId", "initConfig", "initHeightSafeArea", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onFinish", "onProgress", "timeMs", "onSizeChanged", "w", "h", "oldw", "oldh", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onTouchEvent", "pause", "removeCaptionView", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "requestEditing", "editing", "reset", "resume", "setEnableTouch", "showCaptionItemView", "showSelectObjectIdView", "showTimeEditIcon", "bringToFront", "toggleDeleteView", "updateCurTTSStatus", "updateTimeEditorInfo", "updateValidArea", "validRect", "Companion", "plugin-vlog_release"})
public final class TimeEditorItemContainer extends InsectRelativeLayout implements e.c {
    public static final a GNr = new a((byte) 0);
    private final Rect CeT;
    boolean Cfa;
    private View Cfb;
    private kotlin.g.a.b<? super Boolean, x> Cfc;
    private kotlin.g.a.b<? super View, x> Cfd;
    private View Cfe;
    private boolean Cfn;
    private final c GNe;
    private final kotlin.f GNf;
    private final kotlin.f GNg;
    private final kotlin.f GNh;
    private final kotlin.f GNi;
    private final kotlin.f GNj;
    private kotlin.g.a.b<? super com.tencent.mm.plugin.recordvideo.ui.editor.item.a, x> GNk;
    private kotlin.g.a.b<? super com.tencent.mm.plugin.recordvideo.ui.editor.a, x> GNl;
    private kotlin.g.a.b<? super com.tencent.mm.plugin.recordvideo.ui.editor.item.a, x> GNm;
    private kotlin.g.a.b<? super Boolean, x> GNn;
    private long GNo;
    private final m<String, String, com.tencent.mm.ui.widget.a.e> GNp;
    private final i GNq;
    private View.OnClickListener dec;
    private Runnable ruT;
    private RecordConfigProvider wdm;

    static {
        AppMethodBeat.i(191955);
        AppMethodBeat.o(191955);
    }

    private final TextView getDeleteView() {
        AppMethodBeat.i(191925);
        TextView textView = (TextView) this.GNg.getValue();
        AppMethodBeat.o(191925);
        return textView;
    }

    private final ViewGroup getDeleteViewGroup() {
        AppMethodBeat.i(191927);
        ViewGroup viewGroup = (ViewGroup) this.GNi.getValue();
        AppMethodBeat.o(191927);
        return viewGroup;
    }

    private final ImageView getDeleteViewIcon() {
        AppMethodBeat.i(191926);
        ImageView imageView = (ImageView) this.GNh.getValue();
        AppMethodBeat.o(191926);
        return imageView;
    }

    private final b getTimeEditIcon() {
        AppMethodBeat.i(191928);
        b bVar = (b) this.GNj.getValue();
        AppMethodBeat.o(191928);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public final ViewGroup getItemLayout() {
        AppMethodBeat.i(191924);
        ViewGroup viewGroup = (ViewGroup) this.GNf.getValue();
        AppMethodBeat.o(191924);
        return viewGroup;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<View, x> {
        final /* synthetic */ TimeEditorItemContainer GNs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(TimeEditorItemContainer timeEditorItemContainer) {
            super(1);
            this.GNs = timeEditorItemContainer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(View view) {
            AppMethodBeat.i(191911);
            View view2 = view;
            p.h(view2, LocaleUtil.ITALIAN);
            kotlin.g.a.b<View, x> itemChangeListener = this.GNs.getItemChangeListener();
            if (itemChangeListener != null) {
                itemChangeListener.invoke(view2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(191911);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<no name provided>", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "title", "", "menuString", "invoke"})
    static final class d extends q implements m<String, String, com.tencent.mm.ui.widget.a.e> {
        final /* synthetic */ Context $context;
        final /* synthetic */ TimeEditorItemContainer GNs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TimeEditorItemContainer timeEditorItemContainer, Context context) {
            super(2);
            this.GNs = timeEditorItemContainer;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ com.tencent.mm.ui.widget.a.e invoke(String str, String str2) {
            AppMethodBeat.i(191916);
            String str3 = str;
            final String str4 = str2;
            p.h(str3, "title");
            p.h(str4, "menuString");
            final com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(this.$context, 1, true);
            eVar.o(str3, 17);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer.d.AnonymousClass1 */
                final /* synthetic */ d GNt;

                {
                    this.GNt = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(191913);
                    eVar.setFooterView(null);
                    mVar.clear();
                    mVar.a(0, this.GNt.$context.getResources().getColor(R.color.Red), str4);
                    AppMethodBeat.o(191913);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer.d.AnonymousClass2 */
                final /* synthetic */ d GNt;

                {
                    this.GNt = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(191914);
                    p.h(menuItem, "<anonymous parameter 0>");
                    TimeEditorItemContainer.c(this.GNt.GNs).removeView(this.GNt.GNs.Cfe);
                    View view = this.GNt.GNs.Cfe;
                    if (!(view instanceof n)) {
                        view = null;
                    }
                    n nVar = (n) view;
                    if (nVar != null) {
                        nVar.eMs();
                    }
                    kotlin.g.a.b<View, x> itemChangeListener = this.GNt.GNs.getItemChangeListener();
                    if (itemChangeListener != null) {
                        itemChangeListener.invoke(this.GNt.GNs.Cfe);
                    }
                    this.GNt.GNs.post(this.GNt.GNs.ruT);
                    TimeEditorItemContainer.fEr();
                    AppMethodBeat.o(191914);
                }
            });
            eVar.b(new e.b(this) {
                /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer.d.AnonymousClass3 */
                final /* synthetic */ d GNt;

                {
                    this.GNt = r1;
                }

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                    AppMethodBeat.i(191915);
                    this.GNt.GNs.post(this.GNt.GNs.ruT);
                    TimeEditorItemContainer.fEr();
                    AppMethodBeat.o(191915);
                }
            });
            AppMethodBeat.o(191916);
            return eVar;
        }
    }

    public static final /* synthetic */ ViewGroup c(TimeEditorItemContainer timeEditorItemContainer) {
        AppMethodBeat.i(191956);
        ViewGroup itemLayout = timeEditorItemContainer.getItemLayout();
        AppMethodBeat.o(191956);
        return itemLayout;
    }

    public static final /* synthetic */ b e(TimeEditorItemContainer timeEditorItemContainer) {
        AppMethodBeat.i(191957);
        b timeEditIcon = timeEditorItemContainer.getTimeEditIcon();
        AppMethodBeat.o(191957);
        return timeEditIcon;
    }

    public static final /* synthetic */ void fEr() {
    }

    public static final /* synthetic */ String i(TimeEditorItemContainer timeEditorItemContainer) {
        AppMethodBeat.i(191959);
        String dialogTitle = timeEditorItemContainer.getDialogTitle();
        AppMethodBeat.o(191959);
        return dialogTitle;
    }

    public static final /* synthetic */ String j(TimeEditorItemContainer timeEditorItemContainer) {
        AppMethodBeat.i(191960);
        String dialogMenu = timeEditorItemContainer.getDialogMenu();
        AppMethodBeat.o(191960);
        return dialogMenu;
    }

    public static final /* synthetic */ ViewGroup k(TimeEditorItemContainer timeEditorItemContainer) {
        AppMethodBeat.i(191961);
        ViewGroup deleteViewGroup = timeEditorItemContainer.getDeleteViewGroup();
        AppMethodBeat.o(191961);
        return deleteViewGroup;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeEditorItemContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(191953);
        this.GNe = new c();
        this.CeT = new Rect();
        this.GNf = kotlin.g.ah(new h(this));
        this.GNg = kotlin.g.ah(new e(this));
        this.GNh = kotlin.g.ah(new g(this));
        this.GNi = kotlin.g.ah(new f(this));
        this.GNj = kotlin.g.ah(new j(context));
        this.Cfn = true;
        this.ruT = new c(this);
        this.GNp = new d(this, context);
        this.GNq = new i(this);
        View.inflate(context, R.layout.bzf, this);
        com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        Rect eIR = com.tencent.mm.plugin.recordvideo.background.e.eIR();
        Resources resources = getResources();
        p.g(resources, "resources");
        int i3 = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = getResources();
        p.g(resources2, "resources");
        eIR.set(0, 0, i3, resources2.getDisplayMetrics().heightPixels);
        addView(getTimeEditIcon(), new RelativeLayout.LayoutParams(-2, -2));
        getTimeEditIcon().setVisibility(4);
        getTimeEditIcon().setEditTimeListener(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer.AnonymousClass1 */
            final /* synthetic */ TimeEditorItemContainer GNs;

            {
                this.GNs = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(191906);
                View view = this.GNs.Cfe;
                if (view != null && (view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.view.c)) {
                    kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.item.a, x> timeEditClickListener = this.GNs.getTimeEditClickListener();
                    if (timeEditClickListener != null) {
                        timeEditClickListener.invoke(((com.tencent.mm.plugin.recordvideo.ui.editor.view.c) view).getEditorData());
                    }
                    this.GNs.removeCallbacks(this.GNs.ruT);
                    this.GNs.fEn();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191906);
                return xVar;
            }
        });
        getTimeEditIcon().setDeleteListener(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer.AnonymousClass2 */
            final /* synthetic */ TimeEditorItemContainer GNs;

            {
                this.GNs = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(191907);
                this.GNs.removeCallbacks(this.GNs.ruT);
                TimeEditorItemContainer.fEr();
                ((com.tencent.mm.ui.widget.a.e) this.GNs.GNp.invoke(TimeEditorItemContainer.i(this.GNs), TimeEditorItemContainer.j(this.GNs))).dGm();
                this.GNs.Cfb = null;
                x xVar = x.SXb;
                AppMethodBeat.o(191907);
                return xVar;
            }
        });
        getTimeEditIcon().setEditContentListener(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer.AnonymousClass3 */
            final /* synthetic */ TimeEditorItemContainer GNs;

            {
                this.GNs = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(191908);
                View.OnClickListener clickListener = this.GNs.getClickListener();
                if (clickListener != null) {
                    clickListener.onClick(this.GNs.Cfe);
                }
                this.GNs.removeCallbacks(this.GNs.ruT);
                View view = this.GNs.Cfe;
                if (view != null) {
                    view.setActivated(false);
                }
                this.GNs.Cfe = null;
                TimeEditorItemContainer.e(this.GNs).setVisibility(4);
                x xVar = x.SXb;
                AppMethodBeat.o(191908);
                return xVar;
            }
        });
        getTimeEditIcon().setEditCaptionListener(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer.AnonymousClass4 */
            final /* synthetic */ TimeEditorItemContainer GNs;

            {
                this.GNs = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(191909);
                ViewGroup k = TimeEditorItemContainer.k(this.GNs);
                p.g(k, "deleteViewGroup");
                k.setVisibility(8);
                this.GNs.removeCallbacks(this.GNs.ruT);
                TimeEditorItemContainer.e(this.GNs).setVisibility(4);
                kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.a, x> showCaptionDialogListener = this.GNs.getShowCaptionDialogListener();
                if (showCaptionDialogListener != null) {
                    View view = this.GNs.Cfe;
                    if (view == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.CaptionItemView");
                        AppMethodBeat.o(191909);
                        throw tVar;
                    }
                    showCaptionDialogListener.invoke((com.tencent.mm.plugin.recordvideo.ui.editor.a) view);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191909);
                return xVar;
            }
        });
        getTimeEditIcon().setReadTextListener(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.TimeEditorItemContainer.AnonymousClass5 */
            final /* synthetic */ TimeEditorItemContainer GNs;

            {
                this.GNs = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.item.a, x> readTextListener;
                AppMethodBeat.i(191910);
                ViewGroup k = TimeEditorItemContainer.k(this.GNs);
                p.g(k, "deleteViewGroup");
                k.setVisibility(8);
                this.GNs.removeCallbacks(this.GNs.ruT);
                TimeEditorItemContainer.e(this.GNs).setVisibility(4);
                View view = this.GNs.Cfe;
                if (!(view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.view.c)) {
                    view = null;
                }
                com.tencent.mm.plugin.recordvideo.ui.editor.view.c cVar = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c) view;
                if (!(cVar == null || (readTextListener = this.GNs.getReadTextListener()) == null)) {
                    readTextListener.invoke(cVar.getEditorData());
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191910);
                return xVar;
            }
        });
        AppMethodBeat.o(191953);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimeEditorItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(191954);
        AppMethodBeat.o(191954);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditorItemContainer$Companion;", "", "()V", "ClearActiveDelay", "", "DEFAULT", "", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x>, kotlin.g.a.b<java.lang.Boolean, kotlin.x> */
    public final kotlin.g.a.b<Boolean, x> getDeleteStateListener() {
        return this.Cfc;
    }

    public final void setDeleteStateListener(kotlin.g.a.b<? super Boolean, x> bVar) {
        this.Cfc = bVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super android.view.View, kotlin.x>, kotlin.g.a.b<android.view.View, kotlin.x> */
    public final kotlin.g.a.b<View, x> getItemChangeListener() {
        return this.Cfd;
    }

    public final void setItemChangeListener(kotlin.g.a.b<? super View, x> bVar) {
        this.Cfd = bVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.plugin.recordvideo.ui.editor.item.a, kotlin.x>, kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.item.a, kotlin.x> */
    public final kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.item.a, x> getTimeEditClickListener() {
        return this.GNk;
    }

    public final void setTimeEditClickListener(kotlin.g.a.b<? super com.tencent.mm.plugin.recordvideo.ui.editor.item.a, x> bVar) {
        this.GNk = bVar;
    }

    public final View.OnClickListener getClickListener() {
        return this.dec;
    }

    public final void setClickListener(View.OnClickListener onClickListener) {
        this.dec = onClickListener;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.plugin.recordvideo.ui.editor.a, kotlin.x>, kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.a, kotlin.x> */
    public final kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.a, x> getShowCaptionDialogListener() {
        return this.GNl;
    }

    public final void setShowCaptionDialogListener(kotlin.g.a.b<? super com.tencent.mm.plugin.recordvideo.ui.editor.a, x> bVar) {
        this.GNl = bVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.plugin.recordvideo.ui.editor.item.a, kotlin.x>, kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.item.a, kotlin.x> */
    public final kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.item.a, x> getReadTextListener() {
        return this.GNm;
    }

    public final void setReadTextListener(kotlin.g.a.b<? super com.tencent.mm.plugin.recordvideo.ui.editor.item.a, x> bVar) {
        this.GNm = bVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x>, kotlin.g.a.b<java.lang.Boolean, kotlin.x> */
    public final kotlin.g.a.b<Boolean, x> getTimeEditMenuChangeListener() {
        return this.GNn;
    }

    public final void setTimeEditMenuChangeListener(kotlin.g.a.b<? super Boolean, x> bVar) {
        this.GNn = bVar;
    }

    public final long getSegmentOffset() {
        return this.GNo;
    }

    public final void setSegmentOffset(long j2) {
        this.GNo = j2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ TimeEditorItemContainer GNs;

        c(TimeEditorItemContainer timeEditorItemContainer) {
            this.GNs = timeEditorItemContainer;
        }

        public final void run() {
            AppMethodBeat.i(191912);
            this.GNs.t(this.GNs.Cfe, false);
            kotlin.g.a.b<Boolean, x> timeEditMenuChangeListener = this.GNs.getTimeEditMenuChangeListener();
            if (timeEditMenuChangeListener != null) {
                timeEditMenuChangeListener.invoke(Boolean.FALSE);
                AppMethodBeat.o(191912);
                return;
            }
            AppMethodBeat.o(191912);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-vlog_release"})
    public static final class i implements EditorItemContainer.b {
        final /* synthetic */ TimeEditorItemContainer GNs;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(TimeEditorItemContainer timeEditorItemContainer) {
            this.GNs = timeEditorItemContainer;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b
        public final void d(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(191922);
            p.h(view, "itemView");
            p.h(motionEvent, "event");
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.GNs.removeCallbacks(this.GNs.ruT);
                    this.GNs.t(view, true);
                    AppMethodBeat.o(191922);
                    return;
                case 1:
                case 3:
                    if (this.GNs.Cfb == null) {
                        if (this.GNs.Cfe != null) {
                            TimeEditorItemContainer.a(this.GNs, view);
                            break;
                        }
                    } else {
                        this.GNs.post(new a(this));
                        AppMethodBeat.o(191922);
                        return;
                    }
                    break;
                case 2:
                    TimeEditorItemContainer.fEr();
                    TimeEditorItemContainer.e(this.GNs).setVisibility(4);
                    kotlin.g.a.b<Boolean, x> timeEditMenuChangeListener = this.GNs.getTimeEditMenuChangeListener();
                    if (timeEditMenuChangeListener != null) {
                        timeEditMenuChangeListener.invoke(Boolean.TRUE);
                        AppMethodBeat.o(191922);
                        return;
                    }
                    AppMethodBeat.o(191922);
                    return;
            }
            AppMethodBeat.o(191922);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ i GNv;

            a(i iVar) {
                this.GNv = iVar;
            }

            public final void run() {
                AppMethodBeat.i(191921);
                TimeEditorItemContainer.c(this.GNv.GNs).removeView(this.GNv.GNs.Cfb);
                View view = this.GNv.GNs.Cfe;
                if (!(view instanceof n)) {
                    view = null;
                }
                n nVar = (n) view;
                if (nVar != null) {
                    nVar.eMs();
                }
                kotlin.g.a.b<View, x> itemChangeListener = this.GNv.GNs.getItemChangeListener();
                if (itemChangeListener != null) {
                    itemChangeListener.invoke(this.GNv.GNs.Cfb);
                }
                this.GNv.GNs.Cfb = null;
                this.GNv.GNs.Cfe = null;
                AppMethodBeat.o(191921);
            }
        }
    }

    private final String getDialogTitle() {
        AppMethodBeat.i(191929);
        View view = this.Cfe;
        if (view instanceof r) {
            String aI = com.tencent.mm.cb.a.aI(getContext(), R.string.hyd);
            p.g(aI, "ResourceHelper.getString…_track_text_delete_title)");
            AppMethodBeat.o(191929);
            return aI;
        } else if ((view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.b) || (view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f)) {
            String aI2 = com.tencent.mm.cb.a.aI(getContext(), R.string.hy1);
            p.g(aI2, "ResourceHelper.getString…_track_edit_delete_title)");
            AppMethodBeat.o(191929);
            return aI2;
        } else if (view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.a) {
            String aI3 = com.tencent.mm.cb.a.aI(getContext(), R.string.hxx);
            p.g(aI3, "ResourceHelper.getString…ack_caption_delete_title)");
            AppMethodBeat.o(191929);
            return aI3;
        } else {
            String aI4 = com.tencent.mm.cb.a.aI(getContext(), R.string.hy1);
            p.g(aI4, "ResourceHelper.getString…_track_edit_delete_title)");
            AppMethodBeat.o(191929);
            return aI4;
        }
    }

    private final String getDialogMenu() {
        AppMethodBeat.i(191930);
        View view = this.Cfe;
        if (view instanceof r) {
            String string = getContext().getString(R.string.bqe);
            p.g(string, "context.getString(R.stri….editor_item_delete_text)");
            AppMethodBeat.o(191930);
            return string;
        } else if ((view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.b) || (view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f)) {
            String aI = com.tencent.mm.cb.a.aI(getContext(), R.string.hxz);
            p.g(aI, "ResourceHelper.getString….video_track_edit_delete)");
            AppMethodBeat.o(191930);
            return aI;
        } else if (view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.a) {
            String aI2 = com.tencent.mm.cb.a.aI(getContext(), R.string.hxw);
            p.g(aI2, "ResourceHelper.getString…deo_track_caption_delete)");
            AppMethodBeat.o(191930);
            return aI2;
        } else {
            String aI3 = com.tencent.mm.cb.a.aI(getContext(), R.string.hxz);
            p.g(aI3, "ResourceHelper.getString….video_track_edit_delete)");
            AppMethodBeat.o(191930);
            return aI3;
        }
    }

    public final void d(com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar) {
        UICustomParam uICustomParam;
        AppMethodBeat.i(191931);
        p.h(aVar, "info");
        PointF pointF = new PointF(1.0f, 1.0f);
        RecordConfigProvider recordConfigProvider = this.wdm;
        if (!(recordConfigProvider == null || (uICustomParam = recordConfigProvider.BOn) == null)) {
            pointF.x = uICustomParam.gLH;
            pointF.y = uICustomParam.gLI;
        }
        c cVar = this.GNe;
        Context context = getContext();
        p.g(context, "context");
        View a2 = cVar.a(context, aVar, this.GNq, this.CeT, pointF);
        if (a2 != null) {
            getItemLayout().addView(a2, new RelativeLayout.LayoutParams(-1, -1));
            if (this.Cfa && (a2 instanceof MMAnimateView)) {
                ((MMAnimateView) a2).stop();
            }
            removeCallbacks(this.ruT);
            postDelayed(this.ruT, 1500);
        }
        if (a2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.a) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.a) a2).setClearCaptionListener(new b(this));
        }
        AppMethodBeat.o(191931);
    }

    public final void e(com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar) {
        AppMethodBeat.i(191932);
        p.h(aVar, "info");
        ViewGroup itemLayout = getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getItemLayout().getChildAt(i2);
            if (childAt == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.view.IEditView");
                AppMethodBeat.o(191932);
                throw tVar;
            } else if (p.j(((com.tencent.mm.plugin.recordvideo.ui.editor.view.c) childAt).getEditorData(), aVar)) {
                View childAt2 = getItemLayout().getChildAt(i2);
                p.g(childAt2, "itemLayout.getChildAt(i)");
                c.a(childAt2, aVar);
                AppMethodBeat.o(191932);
                return;
            }
        }
        AppMethodBeat.o(191932);
    }

    public final void d(com.tencent.mm.plugin.recordvideo.ui.editor.item.d dVar) {
        AppMethodBeat.i(191933);
        p.h(dVar, "type");
        ViewGroup itemLayout = getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getItemLayout().getChildAt(i2);
            if ((childAt instanceof com.tencent.mm.plugin.recordvideo.ui.editor.a) && ((com.tencent.mm.plugin.recordvideo.ui.editor.a) childAt).a(dVar)) {
                getItemLayout().removeView(getItemLayout().getChildAt(i2));
                AppMethodBeat.o(191933);
                return;
            }
        }
        AppMethodBeat.o(191933);
    }

    public final void fEj() {
        AppMethodBeat.i(191934);
        ViewGroup itemLayout = getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getItemLayout().getChildAt(i2) instanceof com.tencent.mm.plugin.recordvideo.ui.editor.a) {
                View childAt = getItemLayout().getChildAt(i2);
                p.g(childAt, "itemLayout.getChildAt(i)");
                childAt.setVisibility(0);
                AppMethodBeat.o(191934);
                return;
            }
        }
        AppMethodBeat.o(191934);
    }

    public final void aUp(String str) {
        AppMethodBeat.i(191935);
        p.h(str, "objectId");
        ViewGroup itemLayout = getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getItemLayout().getChildAt(i2) instanceof com.tencent.mm.plugin.recordvideo.ui.editor.view.c) {
                View childAt = getItemLayout().getChildAt(i2);
                if (childAt == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.view.IEditView");
                    AppMethodBeat.o(191935);
                    throw tVar;
                }
                ((com.tencent.mm.plugin.recordvideo.ui.editor.view.c) childAt).aLB(str);
            }
        }
        AppMethodBeat.o(191935);
    }

    public final ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> aUq(String str) {
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a cJO;
        AppMethodBeat.i(191936);
        p.h(str, "objectId");
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> arrayList = new ArrayList<>();
        ViewGroup itemLayout = getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getItemLayout().getChildAt(i2);
            if ((childAt instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.g) && (cJO = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g) childAt).cJO()) != null && p.j(cJO.objectId, str)) {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g) childAt).c(null);
                if (c2 == null) {
                    p.hyc();
                }
                arrayList.add(c2);
            }
        }
        AppMethodBeat.o(191936);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void a(e.AbstractC1868e eVar) {
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void onProgress(long j2) {
        AppMethodBeat.i(191937);
        ViewGroup itemLayout = getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getItemLayout().getChildAt(i2);
            if (!(childAt instanceof com.tencent.mm.plugin.recordvideo.ui.editor.view.c)) {
                childAt = null;
            }
            com.tencent.mm.plugin.recordvideo.ui.editor.view.c cVar = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c) childAt;
            if (cVar != null) {
                if (cVar instanceof com.tencent.mm.plugin.recordvideo.ui.editor.a) {
                    cVar.Ig(j2);
                } else {
                    cVar.Ig(this.GNo + j2);
                }
            }
        }
        AppMethodBeat.o(191937);
    }

    public final void a(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(191938);
        p.h(recordConfigProvider, "configProvider");
        this.wdm = recordConfigProvider;
        AppMethodBeat.o(191938);
    }

    public static void ac(float f2, float f3) {
        AppMethodBeat.i(191939);
        com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        com.tencent.mm.plugin.recordvideo.background.e.eIR().left = (int) f3;
        com.tencent.mm.plugin.recordvideo.background.e eVar2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        com.tencent.mm.plugin.recordvideo.background.e.eIR().right = ((int) f3) + ((int) f2);
        StringBuilder sb = new StringBuilder("initWidthSafeArea safeAreaRect:");
        com.tencent.mm.plugin.recordvideo.background.e eVar3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        Log.i("MicroMsg.TimeEditorItemContainer", sb.append(com.tencent.mm.plugin.recordvideo.background.e.eIR()).toString());
        AppMethodBeat.o(191939);
    }

    public static void ad(float f2, float f3) {
        AppMethodBeat.i(191940);
        com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        com.tencent.mm.plugin.recordvideo.background.e.eIR().top = (int) f3;
        com.tencent.mm.plugin.recordvideo.background.e eVar2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        com.tencent.mm.plugin.recordvideo.background.e.eIR().bottom = ((int) f3) + ((int) f2);
        StringBuilder sb = new StringBuilder("initHeightSafeArea safeAreaRect:");
        com.tencent.mm.plugin.recordvideo.background.e eVar3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        Log.i("MicroMsg.TimeEditorItemContainer", sb.append(com.tencent.mm.plugin.recordvideo.background.e.eIR()).toString());
        AppMethodBeat.o(191940);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(191941);
        super.onSizeChanged(i2, i3, i4, i5);
        Log.i("MicroMsg.TimeEditorItemContainer", "onSizeChanged, w:" + i2 + ", h:" + i3);
        this.CeT.set(0, 0, i2, i3);
        AppMethodBeat.o(191941);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(191942);
        p.h(motionEvent, "event");
        if (motionEvent.getActionMasked() == 0 && this.Cfe != null) {
            View view = this.Cfe;
            if (view == null) {
                p.hyc();
            }
            t(view, false);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(191942);
        return onTouchEvent;
    }

    @Override // com.tencent.mm.ui.widget.InsectRelativeLayout
    public final boolean Gv(int i2) {
        AppMethodBeat.i(191943);
        ViewGroup deleteViewGroup = getDeleteViewGroup();
        p.g(deleteViewGroup, "deleteViewGroup");
        ViewGroup.LayoutParams layoutParams = deleteViewGroup.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(191943);
            throw tVar;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 32) + i2;
        ViewGroup deleteViewGroup2 = getDeleteViewGroup();
        p.g(deleteViewGroup2, "deleteViewGroup");
        deleteViewGroup2.setLayoutParams(marginLayoutParams);
        AppMethodBeat.o(191943);
        return true;
    }

    public final ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> getEditorDataList() {
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a cJO;
        AppMethodBeat.i(191944);
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> arrayList = new ArrayList<>();
        ViewGroup itemLayout = getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getItemLayout().getChildAt(i2);
            if ((childAt instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.g) && (cJO = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g) childAt).cJO()) != null) {
                arrayList.add(cJO);
            }
        }
        AppMethodBeat.o(191944);
        return arrayList;
    }

    public final List<com.tencent.mm.plugin.recordvideo.ui.editor.item.g> getAllItemViews() {
        AppMethodBeat.i(191945);
        ArrayList arrayList = new ArrayList();
        ViewGroup itemLayout = getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getItemLayout().getChildAt(i2);
            if (childAt instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.g) {
                arrayList.add(childAt);
            }
        }
        AppMethodBeat.o(191945);
        return arrayList;
    }

    public final void fEn() {
        AppMethodBeat.i(191946);
        View view = this.Cfe;
        if (view != null) {
            t(view, false);
            AppMethodBeat.o(191946);
            return;
        }
        AppMethodBeat.o(191946);
    }

    public final void t(View view, boolean z) {
        AppMethodBeat.i(191947);
        if (!z) {
            this.Cfe = null;
            getTimeEditIcon().setVisibility(4);
        } else if (!p.j(view, this.Cfe)) {
            View view2 = this.Cfe;
            if (view2 != null) {
                view2.setActivated(false);
            }
            this.Cfe = view;
            View view3 = this.Cfe;
            if (view3 != null) {
                view3.bringToFront();
            }
        }
        if (view != null) {
            view.setActivated(z);
            AppMethodBeat.o(191947);
            return;
        }
        AppMethodBeat.o(191947);
    }

    public final void r(Rect rect) {
        AppMethodBeat.i(191948);
        p.h(rect, "validRect");
        ViewGroup itemLayout = getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getItemLayout().getChildAt(i2) instanceof com.tencent.mm.plugin.recordvideo.ui.editor.view.c) {
                View childAt = getItemLayout().getChildAt(i2);
                if (childAt == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.view.IEditView");
                    AppMethodBeat.o(191948);
                    throw tVar;
                }
                ((com.tencent.mm.plugin.recordvideo.ui.editor.view.c) childAt).setValidArea(rect);
            }
        }
        AppMethodBeat.o(191948);
    }

    public final void fEq() {
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar;
        AppMethodBeat.i(191949);
        View view = this.Cfe;
        if (!(view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.view.c)) {
            view = null;
        }
        com.tencent.mm.plugin.recordvideo.ui.editor.view.c cVar = (com.tencent.mm.plugin.recordvideo.ui.editor.view.c) view;
        if (cVar != null) {
            aVar = cVar.getEditorData();
        } else {
            aVar = null;
        }
        if (!(aVar instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.i)) {
            aVar = null;
        }
        com.tencent.mm.plugin.recordvideo.ui.editor.item.i iVar = (com.tencent.mm.plugin.recordvideo.ui.editor.item.i) aVar;
        getTimeEditIcon().setMenuChecked$2563266(iVar != null ? iVar.eMq() : false);
        AppMethodBeat.o(191949);
    }

    public final List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> getAllEditorData() {
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a editorData;
        AppMethodBeat.i(191950);
        ArrayList arrayList = new ArrayList();
        ViewGroup itemLayout = getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getItemLayout().getChildAt(i2);
            if ((childAt instanceof com.tencent.mm.plugin.recordvideo.ui.editor.view.c) && (editorData = ((com.tencent.mm.plugin.recordvideo.ui.editor.view.c) childAt).getEditorData()) != null) {
                arrayList.add(editorData);
            }
        }
        AppMethodBeat.o(191950);
        return arrayList;
    }

    public final List<kotlin.r<String, Long, Long>> getAllTTSData() {
        AppMethodBeat.i(191951);
        ArrayList arrayList = new ArrayList();
        for (T t : getAllEditorData()) {
            T t2 = t;
            if ((t2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.i) && t2.eMq()) {
                arrayList.add(t);
            }
        }
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
        for (com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar : arrayList2) {
            long start = aVar.Cev.getStart();
            long start2 = aVar.Cev.getStart();
            if (aVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.item.IEditorTTSData");
                AppMethodBeat.o(191951);
                throw tVar;
            }
            long j2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.i) aVar).eMp().durationMs + start2;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar = aVar.Ceu;
            if (dVar != null) {
                start = dVar.getStart();
                j2 = dVar.getEnd();
            }
            arrayList3.add(new kotlin.r(((com.tencent.mm.plugin.recordvideo.ui.editor.item.i) aVar).eMp().path, Long.valueOf(start), Long.valueOf(j2)));
        }
        ArrayList arrayList4 = arrayList3;
        AppMethodBeat.o(191951);
        return arrayList4;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(191952);
        if (!this.Cfn) {
            AppMethodBeat.o(191952);
            return true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(191952);
        return dispatchTouchEvent;
    }

    public final void setEnableTouch(boolean z) {
        this.Cfn = z;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ TimeEditorItemContainer GNs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(TimeEditorItemContainer timeEditorItemContainer) {
            super(0);
            this.GNs = timeEditorItemContainer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191920);
            ViewGroup viewGroup = (ViewGroup) this.GNs.findViewById(R.id.bxd);
            AppMethodBeat.o(191920);
            return viewGroup;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ TimeEditorItemContainer GNs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TimeEditorItemContainer timeEditorItemContainer) {
            super(0);
            this.GNs = timeEditorItemContainer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(191917);
            TextView textView = (TextView) this.GNs.findViewById(R.id.bx6);
            AppMethodBeat.o(191917);
            return textView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ TimeEditorItemContainer GNs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(TimeEditorItemContainer timeEditorItemContainer) {
            super(0);
            this.GNs = timeEditorItemContainer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(191919);
            ImageView imageView = (ImageView) this.GNs.findViewById(R.id.bx8);
            AppMethodBeat.o(191919);
            return imageView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ TimeEditorItemContainer GNs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(TimeEditorItemContainer timeEditorItemContainer) {
            super(0);
            this.GNs = timeEditorItemContainer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191918);
            ViewGroup viewGroup = (ViewGroup) this.GNs.findViewById(R.id.bx7);
            AppMethodBeat.o(191918);
            return viewGroup;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView;", "invoke"})
    static final class j extends q implements kotlin.g.a.a<b> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(Context context) {
            super(0);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ b invoke() {
            AppMethodBeat.i(191923);
            b bVar = new b(this.$context);
            AppMethodBeat.o(191923);
            return bVar;
        }
    }

    public static final /* synthetic */ void a(TimeEditorItemContainer timeEditorItemContainer, View view) {
        boolean z;
        int i2;
        boolean z2;
        AppMethodBeat.i(191958);
        if (view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.view.c) {
            RectF drawRect = ((com.tencent.mm.plugin.recordvideo.ui.editor.view.c) view).getDrawRect();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            int i3 = com.tencent.mm.plugin.recordvideo.background.e.eIS().top;
            com.tencent.mm.plugin.recordvideo.background.e eVar2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            float f2 = ((float) com.tencent.mm.plugin.recordvideo.background.e.eIS().bottom) - drawRect.bottom;
            float f3 = drawRect.top - ((float) i3);
            com.tencent.mm.plugin.recordvideo.background.e eVar3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            float height = ((float) com.tencent.mm.plugin.recordvideo.background.e.eIS().top) + (drawRect.height() / 2.0f) + ((float) com.tencent.mm.cb.a.aG(timeEditorItemContainer.getContext(), R.dimen.ct));
            com.tencent.mm.plugin.recordvideo.background.e eVar4 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            float height2 = ((float) com.tencent.mm.plugin.recordvideo.background.e.eIS().bottom) - (((drawRect.height() / 2.0f) + ((float) com.tencent.mm.cb.a.aG(timeEditorItemContainer.getContext(), R.dimen.ct))) + ((float) timeEditorItemContainer.getTimeEditIcon().getMeasuredHeight()));
            if (view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.a) {
                if (!((com.tencent.mm.plugin.recordvideo.ui.editor.a) view).getEnableEdit()) {
                    timeEditorItemContainer.getTimeEditIcon().setVisibility(4);
                    AppMethodBeat.o(191958);
                    return;
                }
                b timeEditIcon = timeEditorItemContainer.getTimeEditIcon();
                timeEditIcon.GMU.setVisibility(0);
                timeEditIcon.GMV.setVisibility(0);
                timeEditIcon.GMR.setVisibility(8);
                timeEditIcon.GMW.setVisibility(8);
                if (f3 >= ((float) timeEditorItemContainer.getTimeEditIcon().getMeasuredHeight()) || f3 >= f2) {
                    timeEditorItemContainer.getTimeEditIcon().fEp();
                    timeEditorItemContainer.getTimeEditIcon().measure(makeMeasureSpec, makeMeasureSpec2);
                    timeEditorItemContainer.getTimeEditIcon().setTranslationY(kotlin.k.j.aJ((drawRect.top - ((float) com.tencent.mm.cb.a.aG(timeEditorItemContainer.getContext(), R.dimen.ct))) - ((float) timeEditorItemContainer.getTimeEditIcon().getMeasuredHeight()), height2));
                } else {
                    timeEditorItemContainer.getTimeEditIcon().fEo();
                    timeEditorItemContainer.getTimeEditIcon().measure(makeMeasureSpec, makeMeasureSpec2);
                    timeEditorItemContainer.getTimeEditIcon().setTranslationY(kotlin.k.j.aI(drawRect.bottom + ((float) com.tencent.mm.cb.a.aG(timeEditorItemContainer.getContext(), R.dimen.ct)), height));
                }
                b timeEditIcon2 = timeEditorItemContainer.getTimeEditIcon();
                Context context = timeEditorItemContainer.getContext();
                p.g(context, "context");
                Resources resources = context.getResources();
                p.g(resources, "context.resources");
                timeEditIcon2.setTranslationX((((float) resources.getDisplayMetrics().widthPixels) / 2.0f) - ((float) (timeEditorItemContainer.getTimeEditIcon().getMeasuredWidth() / 2)));
            } else if ((view instanceof n) || (view instanceof r)) {
                b timeEditIcon3 = timeEditorItemContainer.getTimeEditIcon();
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a editorData = ((com.tencent.mm.plugin.recordvideo.ui.editor.view.c) view).getEditorData();
                if (editorData != null) {
                    z = editorData.Cew;
                } else {
                    z = false;
                }
                timeEditIcon3.GMU.setVisibility(0);
                timeEditIcon3.GMR.setVisibility(z ? 0 : 8);
                timeEditIcon3.GMV.setVisibility(8);
                if (timeEditIcon3.GMX) {
                    ViewGroup viewGroup = timeEditIcon3.GMW;
                    if (z) {
                        i2 = 0;
                    } else {
                        i2 = 8;
                    }
                    viewGroup.setVisibility(i2);
                }
                if (f2 >= ((float) timeEditorItemContainer.getTimeEditIcon().getMeasuredHeight()) || f2 >= f3) {
                    timeEditorItemContainer.getTimeEditIcon().fEo();
                    timeEditorItemContainer.getTimeEditIcon().measure(makeMeasureSpec, makeMeasureSpec2);
                    timeEditorItemContainer.getTimeEditIcon().setTranslationY(kotlin.k.j.aI(drawRect.bottom + ((float) com.tencent.mm.cb.a.aG(timeEditorItemContainer.getContext(), R.dimen.ct)), height));
                } else {
                    timeEditorItemContainer.getTimeEditIcon().fEp();
                    timeEditorItemContainer.getTimeEditIcon().measure(makeMeasureSpec, makeMeasureSpec2);
                    timeEditorItemContainer.getTimeEditIcon().setTranslationY(kotlin.k.j.aJ((drawRect.top - ((float) com.tencent.mm.cb.a.aG(timeEditorItemContainer.getContext(), R.dimen.ct))) - ((float) timeEditorItemContainer.getTimeEditIcon().getMeasuredHeight()), height2));
                }
                timeEditorItemContainer.getTimeEditIcon().setTranslationX(drawRect.centerX() - ((float) (timeEditorItemContainer.getTimeEditIcon().getMeasuredWidth() / 2)));
                timeEditorItemContainer.fEq();
            } else {
                b timeEditIcon4 = timeEditorItemContainer.getTimeEditIcon();
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a editorData2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.view.c) view).getEditorData();
                if (editorData2 != null) {
                    z2 = editorData2.Cew;
                } else {
                    z2 = false;
                }
                timeEditIcon4.GMU.setVisibility(8);
                timeEditIcon4.GMV.setVisibility(8);
                timeEditIcon4.GMR.setVisibility(z2 ? 0 : 8);
                timeEditIcon4.GMW.setVisibility(8);
                if (f2 >= ((float) timeEditorItemContainer.getTimeEditIcon().getMeasuredHeight()) || f2 >= f3) {
                    timeEditorItemContainer.getTimeEditIcon().fEo();
                    timeEditorItemContainer.getTimeEditIcon().measure(makeMeasureSpec, makeMeasureSpec2);
                    timeEditorItemContainer.getTimeEditIcon().setTranslationY(kotlin.k.j.aI(drawRect.bottom + ((float) com.tencent.mm.cb.a.aG(timeEditorItemContainer.getContext(), R.dimen.ct)), height));
                } else {
                    timeEditorItemContainer.getTimeEditIcon().fEp();
                    timeEditorItemContainer.getTimeEditIcon().measure(makeMeasureSpec, makeMeasureSpec2);
                    timeEditorItemContainer.getTimeEditIcon().setTranslationY(kotlin.k.j.aJ((drawRect.top - ((float) com.tencent.mm.cb.a.aG(timeEditorItemContainer.getContext(), R.dimen.ct))) - ((float) timeEditorItemContainer.getTimeEditIcon().getMeasuredHeight()), height2));
                }
                timeEditorItemContainer.getTimeEditIcon().setTranslationX(drawRect.centerX() - ((float) (timeEditorItemContainer.getTimeEditIcon().getMeasuredWidth() / 2)));
            }
            timeEditorItemContainer.getTimeEditIcon().setVisibility(0);
            kotlin.g.a.b<? super Boolean, x> bVar = timeEditorItemContainer.GNn;
            if (bVar != null) {
                bVar.invoke(Boolean.TRUE);
            }
            timeEditorItemContainer.getTimeEditIcon().bringToFront();
            timeEditorItemContainer.getTimeEditIcon().invalidate();
        }
        AppMethodBeat.o(191958);
    }
}
