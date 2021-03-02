package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorFrameView;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d*\u00014\u0018\u0000 ­\u00012\u00020\u00012\u00020\u0002:\u0004­\u0001®\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010Q\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020\u0016H\u0002J\u000e\u0010S\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020UJ\u000e\u0010V\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020XJ\u0014\u0010Y\u001a\u00020\u001a2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[J\u000e\u0010]\u001a\u00020\u001a2\u0006\u0010^\u001a\u00020_J \u0010`\u001a\u00020\u001a2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\nJ\b\u0010e\u001a\u00020\u001aH\u0002J\u0006\u0010f\u001a\u00020\u0016J\u0006\u0010g\u001a\u00020\u0016J\u0006\u0010h\u001a\u00020\u0016J\u0018\u0010i\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00132\u0006\u0010j\u001a\u00020kH\u0002J\u0012\u0010l\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010kH\u0016J\u000e\u0010n\u001a\u00020\u001a2\u0006\u0010o\u001a\u00020\u0016J\u0010\u0010p\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0013H\u0002J\f\u0010q\u001a\b\u0012\u0004\u0012\u00020r0[J\u0006\u0010s\u001a\u00020\"J\u0006\u0010t\u001a\u00020\nJ\u000e\u0010u\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010v\u001a\u00020\u001a2\u0006\u0010w\u001a\u00020-2\u0006\u0010x\u001a\u00020-J\u0016\u0010y\u001a\u00020\u001a2\u0006\u0010z\u001a\u00020-2\u0006\u0010{\u001a\u00020-J\u0010\u0010|\u001a\u00020\u00162\u0006\u0010}\u001a\u00020\nH\u0016J\"\u0010~\u001a\u00020\u001a2\u0006\u0010\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020-H\u0016J\u001b\u0010\u0001\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020-2\u0007\u0010\u0001\u001a\u00020-H\u0016J-\u0010\u0001\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0014J\u0011\u0010\u0001\u001a\u00020\u00162\u0006\u0010j\u001a\u00020kH\u0016J\u0007\u0010\u0001\u001a\u00020\u001aJ\u0019\u0010\u0001\u001a\u00020\u001a2\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0001J\u0007\u0010\u0001\u001a\u00020\u001aJ\u0013\u0010\u0001\u001a\u00020\u001a2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001J\u0007\u0010\u0001\u001a\u00020\u001aJ\u000f\u0010\u0001\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020XJ\u0015\u0010\u0001\u001a\u00020\u001a2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[J\u0018\u0010\u0001\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020\u0016J\u0007\u0010\u0001\u001a\u00020\u001aJ\u0007\u0010\u0001\u001a\u00020\u001aJ\u000f\u0010\u0001\u001a\u00020\u001a2\u0006\u0010o\u001a\u00020\u0016J\u000f\u0010\u0001\u001a\u00020\u001a2\u0006\u00107\u001a\u000208J\u000f\u0010\u0001\u001a\u00020\u001a2\u0006\u0010?\u001a\u000208J\u000f\u0010\u0001\u001a\u00020\u001a2\u0006\u0010H\u001a\u000208J\u000f\u0010\u0001\u001a\u00020\u001a2\u0006\u0010I\u001a\u000208J\u0010\u0010\u0001\u001a\u00020\u001a2\u0007\u0010 \u0001\u001a\u00020\nJ\u0012\u0010¡\u0001\u001a\u00020\u001a2\u0007\u0010¢\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010£\u0001\u001a\u00020\u001a2\u0007\u0010¢\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010¤\u0001\u001a\u00020\u001a2\u0007\u0010¢\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010¥\u0001\u001a\u00020\u001a2\u0007\u0010¢\u0001\u001a\u00020\u0016H\u0002J\u0011\u0010¦\u0001\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0013H\u0002J\u0011\u0010§\u0001\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0013H\u0002J\u0011\u0010¨\u0001\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0013H\u0002J\u0012\u0010©\u0001\u001a\u00020\u001a2\u0007\u0010ª\u0001\u001a\u00020\u0016H\u0002J\u0010\u0010«\u0001\u001a\u00020\u001a2\u0007\u0010¬\u0001\u001a\u00020'R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R7\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R9\u0010.\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR\u000e\u00102\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u000204X\u0004¢\u0006\u0004\n\u0002\u00105R\u0010\u00106\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0010\u0010?\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0010\u0010P\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006¯\u0001"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer;", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "clearActive", "Ljava/lang/Runnable;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "currActiveItem", "Landroid/view/View;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "deleteViewGroup", "Landroid/view/ViewGroup;", "deleteViewIcon", "Landroid/widget/ImageView;", "deletingItem", "displayArea", "Landroid/graphics/Rect;", "getDisplayArea", "()Landroid/graphics/Rect;", "enableTouch", "forceStaticImage", "heightPercent", "", "itemChangeListener", "itemView", "getItemChangeListener", "setItemChangeListener", "itemLayout", "itemStateResolve", "com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1;", "leftFrame", "locationClickListener", "Landroid/view/View$OnClickListener;", "locationView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "getLocationView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "setLocationView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;)V", "lyricsClickListener", "lyricsView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "getLyricsView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "setLyricsView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;)V", "rightFrame", "safeType", "textClickListener", "tipClickListener", "tipItemView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "getTipItemView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "setTipItemView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;)V", "topFrame", "activeDeleteView", "active", "addEmojiItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addLocationItem", "sl", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "addLyricsItem", "lyricsItemInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "addTextItem", "item", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "addTipItem", "text", "", "textColor", "textBgColor", "bringItemsToFront", "checkAddLocationItem", "checkLyricsItem", "checkTipItem", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "enableGif", "enable", "frameCheck", "getAllItemViews", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "getItemLayout", "getLocationItemHeight", "initConfig", "initHeightSafeArea", "safeHeight", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onScale", "scaleFactor", "focusX", "focusY", "onScroll", "distanceX", "distanceY", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "removeLocationView", "callback", "Lkotlin/Function0;", "removeLyricsView", "removeTextItem", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "removeTipItem", "replaceLocationView", "replaceLyricsItem", "requestEditing", "editing", "reset", "resume", "setEnableTouch", "setOnLocationClick", "setOnLyricsClick", "setOnTextClick", "setOnTipClick", "setSafeType", "type", "showBottomFrame", "isShow", "showLeftFrame", "showRightFrame", "showTopFrame", "skipDeleteCheck", "skipFrameCheck", "skipRequestEditing", "toggleDeleteView", "show", "updateValidArea", "validRect", "Companion", "ItemStateResolve", "plugin-recordvideo_release"})
public final class EditorItemContainer extends InsectRelativeLayout implements CropLayout.b {
    public static final a Cfp = new a((byte) 0);
    public final Rect CeT;
    private ImageView CeU;
    private ViewGroup CeV;
    public EditorFrameView CeW;
    public EditorFrameView CeX;
    public EditorFrameView CeY;
    public EditorFrameView CeZ;
    public boolean Cfa;
    private View Cfb;
    private kotlin.g.a.b<? super Boolean, x> Cfc;
    private kotlin.g.a.b<? super View, x> Cfd;
    private View Cfe;
    public p Cff;
    public m Cfg;
    public s Cfh;
    private View.OnClickListener Cfi;
    public View.OnClickListener Cfj;
    public View.OnClickListener Cfk;
    private View.OnClickListener Cfl;
    private int Cfm;
    private boolean Cfn;
    public final d Cfo;
    public float heightPercent;
    private TextView ruM;
    public final ViewGroup ruN;
    public Runnable ruT;
    public RecordConfigProvider wdm;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
    public interface b {
        void d(View view, MotionEvent motionEvent);
    }

    static {
        AppMethodBeat.i(76114);
        AppMethodBeat.o(76114);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        public static final e Cfs = new e();

        static {
            AppMethodBeat.i(76088);
            AppMethodBeat.o(76088);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public static final /* synthetic */ void d(EditorItemContainer editorItemContainer) {
        AppMethodBeat.i(76115);
        editorItemContainer.eMl();
        AppMethodBeat.o(76115);
    }

    public static final /* synthetic */ void i(EditorItemContainer editorItemContainer) {
        AppMethodBeat.i(76119);
        editorItemContainer.tA(false);
        AppMethodBeat.o(76119);
    }

    public static final /* synthetic */ void j(EditorItemContainer editorItemContainer) {
        AppMethodBeat.i(76120);
        editorItemContainer.tB(false);
        AppMethodBeat.o(76120);
    }

    public static final /* synthetic */ void k(EditorItemContainer editorItemContainer) {
        AppMethodBeat.i(76121);
        editorItemContainer.tC(false);
        AppMethodBeat.o(76121);
    }

    public static final /* synthetic */ void l(EditorItemContainer editorItemContainer) {
        AppMethodBeat.i(76122);
        editorItemContainer.tD(false);
        AppMethodBeat.o(76122);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorItemContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(76112);
        this.CeT = new Rect();
        this.ruT = new c(this);
        this.heightPercent = 0.5f;
        this.Cfn = true;
        View.inflate(context, R.layout.bzf, this);
        View findViewById = findViewById(R.id.bxd);
        p.g(findViewById, "findViewById(R.id.editor_item_layout)");
        this.ruN = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.bx6);
        p.g(findViewById2, "findViewById(R.id.editor_delete_view)");
        this.ruM = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.bx8);
        p.g(findViewById3, "findViewById(R.id.editor_delete_view_icon)");
        this.CeU = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.bx7);
        p.g(findViewById4, "findViewById(R.id.editor_delete_view_group)");
        this.CeV = (ViewGroup) findViewById4;
        com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        Rect eIR = com.tencent.mm.plugin.recordvideo.background.e.eIR();
        Resources resources = getResources();
        p.g(resources, "resources");
        int i3 = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = getResources();
        p.g(resources2, "resources");
        eIR.set(0, 0, i3, resources2.getDisplayMetrics().heightPixels);
        this.Cfo = new d(this);
        AppMethodBeat.o(76112);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditorItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(76113);
        AppMethodBeat.o(76113);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$Companion;", "", "()V", "ClearActiveDelay", "", "DEFAULT", "", "JUMP_BACK", "SAFE_LINE", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final Rect getDisplayArea() {
        return this.CeT;
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

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ EditorItemContainer Cfq;

        c(EditorItemContainer editorItemContainer) {
            this.Cfq = editorItemContainer;
        }

        public final void run() {
            AppMethodBeat.i(76085);
            if (this.Cfq.Cfe != null) {
                EditorItemContainer editorItemContainer = this.Cfq;
                View view = this.Cfq.Cfe;
                if (view == null) {
                    p.hyc();
                }
                editorItemContainer.t(view, false);
            }
            AppMethodBeat.o(76085);
        }
    }

    public final p getLocationView() {
        return this.Cff;
    }

    public final void setLocationView(p pVar) {
        this.Cff = pVar;
    }

    public final m getLyricsView() {
        return this.Cfg;
    }

    public final void setLyricsView(m mVar) {
        this.Cfg = mVar;
    }

    public final s getTipItemView() {
        return this.Cfh;
    }

    public final void setTipItemView(s sVar) {
        this.Cfh = sVar;
    }

    public final void setSafeType(int i2) {
        this.Cfm = i2;
        if (this.Cfm == 0) {
            this.heightPercent = 0.7f;
        } else if (this.Cfm == 1) {
            this.heightPercent = 0.5f;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-recordvideo_release"})
    public static final class d implements b {
        final /* synthetic */ EditorItemContainer Cfq;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(EditorItemContainer editorItemContainer) {
            this.Cfq = editorItemContainer;
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b
        public final void d(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(76087);
            p.h(view, "itemView");
            p.h(motionEvent, "event");
            if (this.Cfq.Cfn) {
                EditorItemContainer.d(this.Cfq);
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        this.Cfq.removeCallbacks(this.Cfq.ruT);
                        if (EditorItemContainer.eK(view)) {
                            this.Cfq.t(view, false);
                            AppMethodBeat.o(76087);
                            return;
                        }
                        this.Cfq.t(view, true);
                        AppMethodBeat.o(76087);
                        return;
                    case 1:
                    case 3:
                        if (this.Cfq.Cfb != null) {
                            this.Cfq.post(new a(this, view));
                        } else if (this.Cfq.Cfe != null) {
                            this.Cfq.postDelayed(this.Cfq.ruT, 1500);
                        }
                        EditorItemContainer.a(this.Cfq, false);
                        EditorItemContainer.i(this.Cfq);
                        EditorItemContainer.j(this.Cfq);
                        EditorItemContainer.k(this.Cfq);
                        EditorItemContainer.l(this.Cfq);
                        break;
                    case 2:
                        if (!EditorItemContainer.a(this.Cfq, view)) {
                            EditorItemContainer.b(this.Cfq, view);
                        }
                        if (!EditorItemContainer.eL(view)) {
                            EditorItemContainer.a(this.Cfq, view, motionEvent);
                            EditorItemContainer.a(this.Cfq, true);
                            AppMethodBeat.o(76087);
                            return;
                        }
                        break;
                }
            }
            AppMethodBeat.o(76087);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ d Cfr;
            final /* synthetic */ View rsM;

            a(d dVar, View view) {
                this.Cfr = dVar;
                this.rsM = view;
            }

            public final void run() {
                AppMethodBeat.i(76086);
                this.Cfr.Cfq.ruN.removeView(this.Cfr.Cfq.Cfb);
                kotlin.g.a.b<View, x> itemChangeListener = this.Cfr.Cfq.getItemChangeListener();
                if (itemChangeListener != null) {
                    itemChangeListener.invoke(this.Cfr.Cfq.Cfb);
                }
                this.Cfr.Cfq.Cfb = null;
                this.Cfr.Cfq.Cfe = null;
                if (this.rsM instanceof p) {
                    this.Cfr.Cfq.setLocationView(null);
                    AppMethodBeat.o(76086);
                } else if (this.rsM instanceof m) {
                    this.Cfr.Cfq.setLyricsView(null);
                    AppMethodBeat.o(76086);
                } else {
                    if (this.rsM instanceof s) {
                        this.Cfr.Cfq.setTipItemView(null);
                    }
                    AppMethodBeat.o(76086);
                }
            }
        }
    }

    public final void eMl() {
        m mVar;
        p pVar;
        s sVar;
        AppMethodBeat.i(76089);
        if (!(this.Cfh == null || (sVar = this.Cfh) == null)) {
            sVar.bringToFront();
        }
        if (!(this.Cff == null || (pVar = this.Cff) == null)) {
            pVar.bringToFront();
        }
        if (this.Cfg == null || (mVar = this.Cfg) == null) {
            AppMethodBeat.o(76089);
            return;
        }
        mVar.bringToFront();
        AppMethodBeat.o(76089);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(76090);
        super.onSizeChanged(i2, i3, i4, i5);
        Log.i("MicroMsg.EditorItemContainer", "onSizeChanged, w:" + i2 + ", h:" + i3);
        this.CeT.set(0, 0, i2, i3);
        AppMethodBeat.o(76090);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(76091);
        p.h(motionEvent, "event");
        if (motionEvent.getActionMasked() == 0 && this.Cfe != null) {
            View view = this.Cfe;
            if (view == null) {
                p.hyc();
            }
            t(view, false);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(76091);
        return onTouchEvent;
    }

    @Override // com.tencent.mm.ui.widget.InsectRelativeLayout
    public final boolean Gv(int i2) {
        AppMethodBeat.i(76092);
        ViewGroup.LayoutParams layoutParams = this.CeV.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(76092);
            throw tVar;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 32) + i2;
        this.CeV.setLayoutParams(marginLayoutParams);
        AppMethodBeat.o(76092);
        return true;
    }

    public final void eMm() {
        AppMethodBeat.i(76093);
        if (this.Cfh != null) {
            this.ruN.removeView(this.Cfh);
            this.Cfh = null;
        }
        AppMethodBeat.o(76093);
    }

    public final void gl(List<? extends ckm> list) {
        AppMethodBeat.i(76094);
        p.h(list, "lyricsItemInfos");
        this.Cfg = new m(getContext());
        this.ruN.addView(this.Cfg, new RelativeLayout.LayoutParams(-1, -1));
        m mVar = this.Cfg;
        if (mVar != null) {
            com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            Rect eIR = com.tencent.mm.plugin.recordvideo.background.e.eIR();
            com.tencent.mm.plugin.recordvideo.background.e eVar2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            mVar.b(eIR, com.tencent.mm.plugin.recordvideo.background.e.eIT());
        }
        m mVar2 = this.Cfg;
        if (mVar2 != null) {
            com.tencent.mm.plugin.recordvideo.background.e eVar3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            mVar2.setValidArea(com.tencent.mm.plugin.recordvideo.background.e.eIS());
        }
        m mVar3 = this.Cfg;
        if (mVar3 != null) {
            c.a.a(mVar3, this.CeT);
        }
        m mVar4 = this.Cfg;
        if (mVar4 != null) {
            mVar4.setStateResolve(this.Cfo);
        }
        m mVar5 = this.Cfg;
        if (mVar5 != null) {
            mVar5.gm(list);
            AppMethodBeat.o(76094);
            return;
        }
        AppMethodBeat.o(76094);
    }

    public final void eMn() {
        AppMethodBeat.i(76095);
        if (this.Cfg != null) {
            this.ruN.removeView(this.Cfg);
        }
        this.Cfg = null;
        AppMethodBeat.o(76095);
    }

    public final boolean eMo() {
        return this.Cff != null;
    }

    public final void a(dlg dlg) {
        AppMethodBeat.i(76096);
        p.h(dlg, "sl");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        Context context = getContext();
        p.g(context, "context");
        this.Cff = new p(context);
        p pVar = this.Cff;
        if (pVar != null) {
            com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            Rect eIR = com.tencent.mm.plugin.recordvideo.background.e.eIR();
            com.tencent.mm.plugin.recordvideo.background.e eVar2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            pVar.b(eIR, com.tencent.mm.plugin.recordvideo.background.e.eIT());
        }
        p pVar2 = this.Cff;
        if (pVar2 != null) {
            com.tencent.mm.plugin.recordvideo.background.e eVar3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            pVar2.setValidArea(com.tencent.mm.plugin.recordvideo.background.e.eIS());
        }
        p pVar3 = this.Cff;
        if (pVar3 != null) {
            pVar3.a(this.CeT, this.heightPercent);
        }
        p pVar4 = this.Cff;
        if (pVar4 != null) {
            pVar4.setLocation(dlg);
        }
        p pVar5 = this.Cff;
        if (pVar5 != null) {
            pVar5.setStateResolve(this.Cfo);
        }
        p pVar6 = this.Cff;
        if (pVar6 != null) {
            pVar6.setOnClickListener(this.Cfi);
        }
        this.ruN.addView(this.Cff, layoutParams);
        p pVar7 = this.Cff;
        if (pVar7 == null) {
            p.hyc();
        }
        t(pVar7, false);
        removeCallbacks(this.ruT);
        postDelayed(this.ruT, 1500);
        AppMethodBeat.o(76096);
    }

    public final void ab(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(76097);
        if (this.Cff != null) {
            this.ruN.removeView(this.Cff);
        }
        this.Cff = null;
        if (aVar != null) {
            aVar.invoke();
            AppMethodBeat.o(76097);
            return;
        }
        AppMethodBeat.o(76097);
    }

    public final void setOnLocationClick(View.OnClickListener onClickListener) {
        AppMethodBeat.i(76098);
        p.h(onClickListener, "locationClickListener");
        this.Cfi = onClickListener;
        AppMethodBeat.o(76098);
    }

    public final void setOnTextClick(View.OnClickListener onClickListener) {
        AppMethodBeat.i(76099);
        p.h(onClickListener, "textClickListener");
        this.Cfj = onClickListener;
        AppMethodBeat.o(76099);
    }

    public final void setOnTipClick(View.OnClickListener onClickListener) {
        AppMethodBeat.i(76100);
        p.h(onClickListener, "tipClickListener");
        this.Cfk = onClickListener;
        AppMethodBeat.o(76100);
    }

    public final void setOnLyricsClick(View.OnClickListener onClickListener) {
        AppMethodBeat.i(76101);
        p.h(onClickListener, "lyricsClickListener");
        this.Cfl = onClickListener;
        AppMethodBeat.o(76101);
    }

    public final List<g> getAllItemViews() {
        AppMethodBeat.i(76102);
        ArrayList arrayList = new ArrayList();
        int childCount = this.ruN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ruN.getChildAt(i2);
            if (childAt instanceof g) {
                arrayList.add(childAt);
            }
        }
        AppMethodBeat.o(76102);
        return arrayList;
    }

    public final ViewGroup getItemLayout() {
        return this.ruN;
    }

    public final void t(View view, boolean z) {
        AppMethodBeat.i(76103);
        p.h(view, "itemView");
        if (z) {
            if (!p.j(view, this.Cfe)) {
                View view2 = this.Cfe;
                if (view2 != null) {
                    view2.setActivated(false);
                }
                this.Cfe = view;
            }
        } else if (p.j(view, this.Cfe)) {
            this.Cfe = null;
        }
        view.setActivated(z);
        AppMethodBeat.o(76103);
    }

    private final void lN(boolean z) {
        AppMethodBeat.i(76104);
        this.CeV.setActivated(z);
        if (z) {
            this.ruM.setText(R.string.bqg);
            this.CeU.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_delete_on, -1));
            AppMethodBeat.o(76104);
            return;
        }
        this.ruM.setText(R.string.bqf);
        this.CeU.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_delete, -1));
        AppMethodBeat.o(76104);
    }

    public final void reset() {
        AppMethodBeat.i(76105);
        this.Cff = null;
        this.Cfh = null;
        this.Cfg = null;
        this.ruN.removeAllViews();
        AppMethodBeat.o(76105);
    }

    public final int getLocationItemHeight() {
        Bitmap bitmap;
        AppMethodBeat.i(76106);
        p pVar = this.Cff;
        if (pVar == null || (bitmap = pVar.getBitmap()) == null) {
            AppMethodBeat.o(76106);
            return 0;
        }
        int height = bitmap.getHeight();
        AppMethodBeat.o(76106);
        return height;
    }

    private final void tA(boolean z) {
        AppMethodBeat.i(76107);
        EditorFrameView editorFrameView = this.CeW;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.o(76107);
            return;
        }
        AppMethodBeat.o(76107);
    }

    private final void tB(boolean z) {
        AppMethodBeat.i(76108);
        EditorFrameView editorFrameView = this.CeX;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.o(76108);
            return;
        }
        AppMethodBeat.o(76108);
    }

    private final void tC(boolean z) {
        AppMethodBeat.i(76109);
        EditorFrameView editorFrameView = this.CeY;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.o(76109);
            return;
        }
        AppMethodBeat.o(76109);
    }

    private final void tD(boolean z) {
        AppMethodBeat.i(76110);
        EditorFrameView editorFrameView = this.CeZ;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.o(76110);
            return;
        }
        AppMethodBeat.o(76110);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(76111);
        if (!this.Cfn) {
            AppMethodBeat.o(76111);
            return true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(76111);
        return dispatchTouchEvent;
    }

    public final void setEnableTouch(boolean z) {
        this.Cfn = z;
    }

    @Override // com.tencent.mm.ui.widget.cropview.CropLayout.b
    public final void onScroll(float f2, float f3) {
        AppMethodBeat.i(237758);
        int childCount = this.ruN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ruN.getChildAt(i2);
            if (childAt instanceof f) {
                ((f) childAt).getTouchTracker().gT.postTranslate(f2, f3);
                childAt.invalidate();
            }
            if (childAt instanceof r) {
                ((r) childAt).getTouchTracker().gT.postTranslate(f2, f3);
                childAt.invalidate();
            }
        }
        AppMethodBeat.o(237758);
    }

    @Override // com.tencent.mm.ui.widget.cropview.CropLayout.b
    public final void o(float f2, float f3, float f4) {
        AppMethodBeat.i(237759);
        int childCount = this.ruN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ruN.getChildAt(i2);
            if (childAt instanceof f) {
                ((f) childAt).getTouchTracker().gT.postScale(f2, f2, f3, f4);
                childAt.invalidate();
            } else if (childAt instanceof r) {
                ((r) childAt).getTouchTracker().gT.postScale(f2, f2, f3, f4);
                childAt.invalidate();
            }
        }
        AppMethodBeat.o(237759);
    }

    public static final /* synthetic */ boolean eK(View view) {
        return (view instanceof p) || (view instanceof s);
    }

    public static final /* synthetic */ boolean a(EditorItemContainer editorItemContainer, View view) {
        return (view instanceof s) || (view instanceof p) || editorItemContainer.Cfm != 0;
    }

    public static final /* synthetic */ void b(EditorItemContainer editorItemContainer, View view) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(76116);
        if (view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.view.c) {
            float[] contentBoundary = ((com.tencent.mm.plugin.recordvideo.ui.editor.view.c) view).getContentBoundary();
            float f2 = contentBoundary[0];
            float f3 = contentBoundary[1];
            float f4 = contentBoundary[2];
            float f5 = contentBoundary[3];
            com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            editorItemContainer.tA(f2 <= ((float) com.tencent.mm.plugin.recordvideo.background.e.eIR().left));
            com.tencent.mm.plugin.recordvideo.background.e eVar2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            if (f3 <= ((float) com.tencent.mm.plugin.recordvideo.background.e.eIR().top)) {
                z = true;
            } else {
                z = false;
            }
            editorItemContainer.tB(z);
            com.tencent.mm.plugin.recordvideo.background.e eVar3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            if (f4 >= ((float) com.tencent.mm.plugin.recordvideo.background.e.eIR().right)) {
                z2 = true;
            } else {
                z2 = false;
            }
            editorItemContainer.tC(z2);
            com.tencent.mm.plugin.recordvideo.background.e eVar4 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            if (f5 < ((float) com.tencent.mm.plugin.recordvideo.background.e.eIR().bottom)) {
                z3 = false;
            }
            editorItemContainer.tD(z3);
        }
        AppMethodBeat.o(76116);
    }

    public static final /* synthetic */ boolean eL(View view) {
        return (view instanceof s) || (view instanceof p);
    }

    public static final /* synthetic */ boolean a(EditorItemContainer editorItemContainer, View view, MotionEvent motionEvent) {
        AppMethodBeat.i(76117);
        int pointerCount = motionEvent.getPointerCount();
        int i2 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < pointerCount) {
            float y = motionEvent.getY(i2) + f3;
            f2 += motionEvent.getX(i2);
            i2++;
            f3 = y;
        }
        float f4 = f2 / ((float) pointerCount);
        boolean z = editorItemContainer.CeV.getTop() > 0 && f3 / ((float) pointerCount) > ((float) editorItemContainer.CeV.getTop()) && ((float) editorItemContainer.CeV.getLeft()) < f4 && ((float) editorItemContainer.CeV.getRight()) > f4;
        if (z) {
            editorItemContainer.lN(true);
            if (editorItemContainer.Cfb == null) {
                editorItemContainer.Cfb = view;
                view.animate().alpha(0.5f).setDuration(100).start();
            }
        } else {
            editorItemContainer.lN(false);
            if (editorItemContainer.Cfb != null) {
                editorItemContainer.Cfb = null;
                view.animate().alpha(1.0f).setDuration(100).start();
            }
        }
        AppMethodBeat.o(76117);
        return z;
    }

    public static final /* synthetic */ void a(EditorItemContainer editorItemContainer, boolean z) {
        AppMethodBeat.i(76118);
        editorItemContainer.CeV.setVisibility(z ? 0 : 8);
        kotlin.g.a.b<? super Boolean, x> bVar = editorItemContainer.Cfc;
        if (bVar != null) {
            bVar.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(76118);
            return;
        }
        AppMethodBeat.o(76118);
    }
}
