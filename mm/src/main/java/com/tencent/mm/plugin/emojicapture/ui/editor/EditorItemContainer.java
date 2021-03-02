package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ad.a.g;
import com.tencent.mm.plugin.appbrand.ad.a.h;
import com.tencent.mm.plugin.appbrand.ad.a.i;
import com.tencent.mm.plugin.appbrand.ad.a.j;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

public final class EditorItemContainer extends RelativeLayout {
    public static final a ruW = new a((byte) 0);
    private final String TAG;
    private View ruL;
    private TextView ruM;
    public final ViewGroup ruN;
    public final EditorOutsideView ruO;
    private b ruP;
    private boolean ruQ;
    private final RectF ruR;
    private a ruS;
    private Runnable ruT;
    private a ruU;
    private final LinkedList<Runnable> ruV;

    public interface b {
        void lL(boolean z);
    }

    static {
        AppMethodBeat.i(762);
        AppMethodBeat.o(762);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorItemContainer(final Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(760);
        this.TAG = "MicroMsg.EditorItemContainer";
        this.ruQ = true;
        this.ruR = new RectF();
        this.ruT = new d(this);
        this.ruV = new LinkedList<>();
        View.inflate(context, R.layout.a1d, this);
        View findViewById = findViewById(R.id.bxx);
        p.g(findViewById, "findViewById(R.id.editor_valid_area)");
        this.ruL = findViewById;
        View findViewById2 = findViewById(R.id.bx6);
        p.g(findViewById2, "findViewById(R.id.editor_delete_view)");
        this.ruM = (TextView) findViewById2;
        this.ruM.setTextColor(getResources().getColor(R.color.mm));
        View findViewById3 = findViewById(R.id.bz0);
        p.g(findViewById3, "findViewById(R.id.emoji_capture_editor_layout)");
        this.ruN = (ViewGroup) findViewById3;
        View findViewById4 = findViewById(R.id.bz1);
        p.g(findViewById4, "findViewById(R.id.emoji_capture_editor_mask)");
        this.ruO = (EditorOutsideView) findViewById4;
        al(new Runnable(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer.AnonymousClass1 */
            final /* synthetic */ EditorItemContainer ruX;

            {
                this.ruX = r1;
            }

            public final void run() {
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.b.CTRL_INDEX);
                this.ruX.ruO.a(this.ruX.getValidRect(), context.getResources().getDimension(R.dimen.a1w));
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.b.CTRL_INDEX);
            }
        });
        AppMethodBeat.o(760);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditorItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(761);
        AppMethodBeat.o(761);
    }

    public final b getStateChangeListener() {
        return this.ruP;
    }

    public final void setStateChangeListener(b bVar) {
        this.ruP = bVar;
    }

    public final boolean getDeleteEnalbe() {
        return this.ruQ;
    }

    public final void setDeleteEnalbe(boolean z) {
        this.ruQ = z;
    }

    /* access modifiers changed from: package-private */
    public static final class d implements Runnable {
        final /* synthetic */ EditorItemContainer ruX;

        d(EditorItemContainer editorItemContainer) {
            this.ruX = editorItemContainer;
        }

        public final void run() {
            AppMethodBeat.i(738);
            if (this.ruX.ruS != null) {
                EditorItemContainer editorItemContainer = this.ruX;
                a aVar = this.ruX.ruS;
                if (aVar == null) {
                    p.hyc();
                }
                editorItemContainer.a(aVar, false);
            }
            AppMethodBeat.o(738);
        }
    }

    public static /* synthetic */ void a(EditorItemContainer editorItemContainer, a aVar) {
        AppMethodBeat.i(742);
        editorItemContainer.a(aVar, (Matrix) null);
        AppMethodBeat.o(742);
    }

    public static final class c implements Runnable {
        final /* synthetic */ EditorItemContainer ruX;
        final /* synthetic */ a ruY;
        final /* synthetic */ Matrix ruZ;

        c(EditorItemContainer editorItemContainer, a aVar, Matrix matrix) {
            this.ruX = editorItemContainer;
            this.ruY = aVar;
            this.ruZ = matrix;
        }

        public final void run() {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.c.CTRL_INDEX);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            ViewGroup viewGroup = this.ruX.ruN;
            a aVar = this.ruY;
            if (aVar == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.c.CTRL_INDEX);
                throw tVar;
            }
            viewGroup.addView((View) aVar, layoutParams);
            a aVar2 = this.ruY;
            RectF validRect = this.ruX.getValidRect();
            Context context = this.ruX.getContext();
            p.g(context, "context");
            aVar2.a(validRect, context.getResources().getDimension(R.dimen.a1w));
            this.ruX.setEditing(this.ruY);
            this.ruX.ruN.bringChildToFront(this.ruX.getTextItem());
            if (this.ruZ != null && (this.ruY instanceof EmojiEditorItemView)) {
                Matrix matrix = this.ruZ;
                p.h(matrix, "m");
                ((EmojiEditorItemView) this.ruY).rvc.getTouchTracker().gT.set(matrix);
            }
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.c.CTRL_INDEX);
        }
    }

    public final void a(a aVar, Matrix matrix) {
        AppMethodBeat.i(741);
        p.h(aVar, "itemView");
        al(new c(this, aVar, matrix));
        AppMethodBeat.o(741);
    }

    public final void a(a aVar, MotionEvent motionEvent) {
        AppMethodBeat.i(743);
        p.h(aVar, "itemView");
        p.h(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                removeCallbacks(this.ruT);
                a(aVar, true);
                AppMethodBeat.o(743);
                return;
            case 1:
            case 3:
                this.ruN.bringChildToFront(getTextItem());
                if (this.ruU != null) {
                    post(new e(this));
                } else if (this.ruS != null) {
                    postDelayed(this.ruT, 1500);
                }
                lM(false);
                break;
            case 2:
                if (this.ruQ) {
                    b(aVar, motionEvent);
                    lM(true);
                    AppMethodBeat.o(743);
                    return;
                }
                break;
        }
        AppMethodBeat.o(743);
    }

    /* access modifiers changed from: package-private */
    public static final class e implements Runnable {
        final /* synthetic */ EditorItemContainer ruX;

        e(EditorItemContainer editorItemContainer) {
            this.ruX = editorItemContainer;
        }

        public final void run() {
            AppMethodBeat.i(739);
            if (this.ruX.ruU != null) {
                a aVar = this.ruX.ruU;
                if (aVar == null) {
                    p.hyc();
                }
                if (!aVar.cJP()) {
                    ViewGroup viewGroup = this.ruX.ruN;
                    a aVar2 = this.ruX.ruU;
                    if (aVar2 == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(739);
                        throw tVar;
                    }
                    viewGroup.removeView((View) aVar2);
                }
            }
            this.ruX.ruU = null;
            this.ruX.ruS = null;
            AppMethodBeat.o(739);
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(744);
        p.h(motionEvent, "ev");
        if (motionEvent.getActionMasked() != 0 || this.ruR.contains(motionEvent.getX(), motionEvent.getY())) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(744);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.o(744);
        return true;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(745);
        if (motionEvent != null && motionEvent.getActionMasked() == 0) {
            if (!this.ruR.contains(motionEvent.getX(), motionEvent.getY())) {
                AppMethodBeat.o(745);
                return false;
            } else if (this.ruS != null) {
                a aVar = this.ruS;
                if (aVar == null) {
                    p.hyc();
                }
                a(aVar, false);
            }
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(745);
        return onTouchEvent;
    }

    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(746);
        super.onSizeChanged(i2, i3, i4, i5);
        if (!(i2 == i4 && i3 == i5)) {
            post(new f(this));
        }
        AppMethodBeat.o(746);
    }

    static final class f implements Runnable {
        final /* synthetic */ EditorItemContainer ruX;

        f(EditorItemContainer editorItemContainer) {
            this.ruX = editorItemContainer;
        }

        public final void run() {
            AppMethodBeat.i(740);
            this.ruX.getValidRect();
            if (!this.ruX.ruR.isEmpty()) {
                for (Runnable runnable : this.ruX.ruV) {
                    runnable.run();
                }
            }
            AppMethodBeat.o(740);
        }
    }

    public final TextEditorItemView getTextItem() {
        AppMethodBeat.i(av.CTRL_INDEX);
        int childCount = this.ruN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ruN.getChildAt(i2);
            if (childAt instanceof TextEditorItemView) {
                TextEditorItemView textEditorItemView = (TextEditorItemView) childAt;
                AppMethodBeat.o(av.CTRL_INDEX);
                return textEditorItemView;
            }
        }
        AppMethodBeat.o(av.CTRL_INDEX);
        return null;
    }

    public final String getAttachedText() {
        AppMethodBeat.i(h.CTRL_INDEX);
        TextEditorItemView textItem = getTextItem();
        if (textItem == null) {
            AppMethodBeat.o(h.CTRL_INDEX);
            return null;
        } else if (textItem.getText() == null) {
            AppMethodBeat.o(h.CTRL_INDEX);
            return null;
        } else {
            String valueOf = String.valueOf(textItem.getText());
            AppMethodBeat.o(h.CTRL_INDEX);
            return valueOf;
        }
    }

    public final ArrayList<String> getAllEmojiMd5() {
        EmojiInfo emojiInfo;
        String md5;
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.ad.a.a.CTRL_INDEX);
        ArrayList<String> arrayList = new ArrayList<>();
        int childCount = this.ruN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ruN.getChildAt(i2);
            if (!(!(childAt instanceof EmojiEditorItemView) || (emojiInfo = ((EmojiEditorItemView) childAt).getEmojiInfo()) == null || (md5 = emojiInfo.getMd5()) == null)) {
                arrayList.add(md5);
            }
        }
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.ad.a.a.CTRL_INDEX);
        return arrayList;
    }

    public final List<a> getAllItemViews() {
        AppMethodBeat.i(750);
        ArrayList arrayList = new ArrayList();
        int childCount = this.ruN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ruN.getChildAt(i2);
            if (childAt instanceof a) {
                arrayList.add(childAt);
            }
        }
        AppMethodBeat.o(750);
        return arrayList;
    }

    public final void resume() {
        AppMethodBeat.i(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA);
        int childCount = this.ruN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ruN.getChildAt(i2);
            if (childAt instanceof a) {
                ((a) childAt).resume();
            }
        }
        AppMethodBeat.o(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA);
    }

    public final void pause() {
        AppMethodBeat.i(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA);
        int childCount = this.ruN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ruN.getChildAt(i2);
            if (childAt instanceof a) {
                ((a) childAt).pause();
            }
        }
        AppMethodBeat.o(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA);
    }

    public final RectF getValidRect() {
        AppMethodBeat.i(753);
        this.ruR.set((float) this.ruL.getLeft(), (float) this.ruL.getTop(), (float) this.ruL.getRight(), (float) this.ruL.getBottom());
        RectF rectF = this.ruR;
        AppMethodBeat.o(753);
        return rectF;
    }

    public final void setEditing(a aVar) {
        AppMethodBeat.i(u.CTRL_INDEX);
        p.h(aVar, "itemView");
        removeCallbacks(this.ruT);
        a(aVar, true);
        postDelayed(this.ruT, 1500);
        AppMethodBeat.o(u.CTRL_INDEX);
    }

    public final void a(a aVar, boolean z) {
        AppMethodBeat.i(cp.CTRL_INDEX);
        p.h(aVar, "itemView");
        if (z) {
            if (!p.j(aVar, this.ruS)) {
                a aVar2 = this.ruS;
                if (aVar2 != null) {
                    aVar2.setEditing(false);
                }
                this.ruS = aVar;
            }
        } else if (p.j(aVar, this.ruS)) {
            this.ruS = null;
        }
        aVar.setEditing(z);
        AppMethodBeat.o(cp.CTRL_INDEX);
    }

    public final void al(Runnable runnable) {
        AppMethodBeat.i(g.CTRL_INDEX);
        p.h(runnable, "r");
        if (!this.ruR.isEmpty()) {
            runnable.run();
            AppMethodBeat.o(g.CTRL_INDEX);
            return;
        }
        this.ruV.add(runnable);
        AppMethodBeat.o(g.CTRL_INDEX);
    }

    private final void lM(boolean z) {
        AppMethodBeat.i(j.CTRL_INDEX);
        this.ruM.setVisibility(z ? 0 : 8);
        if (this.ruP != null) {
            b bVar = this.ruP;
            if (bVar == null) {
                p.hyc();
            }
            bVar.lL(z);
        }
        AppMethodBeat.o(j.CTRL_INDEX);
    }

    private final void lN(boolean z) {
        AppMethodBeat.i(i.CTRL_INDEX);
        this.ruM.setActivated(z);
        if (z) {
            this.ruM.setText(R.string.bqg);
            AppMethodBeat.o(i.CTRL_INDEX);
            return;
        }
        this.ruM.setText(R.string.bqf);
        AppMethodBeat.o(i.CTRL_INDEX);
    }

    private final boolean b(a aVar, MotionEvent motionEvent) {
        AppMethodBeat.i(759);
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            f2 += motionEvent.getY(i2);
        }
        boolean z = f2 / ((float) pointerCount) > ((float) this.ruM.getTop());
        if (z) {
            lN(true);
            if (this.ruU == null) {
                this.ruU = aVar;
            }
        } else {
            lN(false);
            if (this.ruU != null) {
                this.ruU = null;
            }
        }
        AppMethodBeat.o(759);
        return z;
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        AppMethodBeat.i(256447);
        if (windowInsets == null) {
            WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
            p.g(onApplyWindowInsets, "super.onApplyWindowInsets(insets)");
            AppMethodBeat.o(256447);
            return onApplyWindowInsets;
        }
        ViewGroup.LayoutParams layoutParams = this.ruL.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Log.i(this.TAG, "onApplyWindowInsets: " + (marginLayoutParams != null));
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ag4) + windowInsets.getSystemWindowInsetTop();
            this.ruL.setLayoutParams(marginLayoutParams);
        }
        WindowInsets onApplyWindowInsets2 = super.onApplyWindowInsets(windowInsets);
        p.g(onApplyWindowInsets2, "super.onApplyWindowInsets(insets)");
        AppMethodBeat.o(256447);
        return onApplyWindowInsets2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
