package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.ui.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.m.b;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010#\u001a\u00020\u0017H\u0016J\u0012\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0006\u0010'\u001a\u00020\u0017J\"\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0016J,\u0010,\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J$\u00101\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u00102\b\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u00103\u001a\u00020\tH\u0016J$\u00104\u001a\u00020 2\b\u00102\u001a\u0004\u0018\u00010\u00102\b\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u00105\u001a\u00020\tH\u0016J\u0012\u00106\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u00107\u001a\u00020\u0017J\b\u00108\u001a\u00020\u0017H\u0002J\b\u00109\u001a\u00020\u0017H\u0002J\u000e\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "contentView", "Landroid/support/v7/widget/RecyclerView;", "delView", "Landroid/view/View;", "downX", "", "downY", "lastScrollX", "onDeleteClick", "Lkotlin/Function0;", "", "getOnDeleteClick", "()Lkotlin/jvm/functions/Function0;", "setOnDeleteClick", "(Lkotlin/jvm/functions/Function0;)V", "overScroller", "Landroid/widget/Scroller;", "scrollDistance", "scrolling", "", "touchHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "computeScroll", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onListScroll", "onNestedPreFling", "target", "velocityX", "velocityY", "onNestedPreScroll", "dx", "dy", "consumed", "", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "resetHeader", "scrollHideDelGroup", "scrollShowDelGroup", "setContentAdapter", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryHeaderTipAdapter;", "plugin-story_release"})
public final class StoryHeaderStageGroup extends RelativeLayout {
    final RecyclerView FCJ;
    private final Scroller FCK;
    private final b FCL;
    private int FCM;
    private int FCN;
    private a<x> FCO;
    final String TAG;
    private float deo;
    private float dep;
    private final View plg;
    private boolean scrolling;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryHeaderStageGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120180);
        this.TAG = "MicroMsg.StoryHeaderStageGroup";
        View.inflate(context, R.layout.c0b, this);
        View findViewById = findViewById(R.id.i0k);
        p.g(findViewById, "findViewById(R.id.sns_st…header_tip_stage_content)");
        this.FCJ = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.i0m);
        p.g(findViewById2, "findViewById(R.id.sns_st…ader_tip_stage_del_group)");
        this.plg = findViewById2;
        this.FCK = new Scroller(context);
        this.FCL = new b(context);
        this.FCJ.setLayoutManager(new LinearLayoutManager(0, false));
        this.plg.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryHeaderStageGroup.AnonymousClass1 */
            final /* synthetic */ StoryHeaderStageGroup FCP;

            {
                this.FCP = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120170);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a<x> onDeleteClick = this.FCP.getOnDeleteClick();
                if (onDeleteClick != null) {
                    onDeleteClick.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryHeaderStageGroup$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120170);
            }
        });
        AppMethodBeat.o(120180);
    }

    public final a<x> getOnDeleteClick() {
        return this.FCO;
    }

    public final void setOnDeleteClick(a<x> aVar) {
        this.FCO = aVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryHeaderStageGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120181);
        AppMethodBeat.o(120181);
    }

    public final void setContentAdapter(j jVar) {
        AppMethodBeat.i(120171);
        p.h(jVar, "adapter");
        this.FCJ.setAdapter(jVar);
        AppMethodBeat.o(120171);
    }

    private final void fsb() {
        AppMethodBeat.i(120172);
        if (!this.scrolling) {
            this.scrolling = true;
            this.FCK.startScroll(this.FCM, 0, (this.plg.getMeasuredWidth() + at.fromDPToPix(getContext(), 20)) - this.FCM, 0);
            invalidate();
        }
        AppMethodBeat.o(120172);
    }

    /* access modifiers changed from: package-private */
    public final void fsc() {
        AppMethodBeat.i(120173);
        if (!this.scrolling) {
            this.scrolling = true;
            this.FCK.startScroll(this.FCM, 0, 0 - this.FCM, 0);
            invalidate();
        }
        AppMethodBeat.o(120173);
    }

    public final void computeScroll() {
        AppMethodBeat.i(120174);
        if (this.FCK.computeScrollOffset()) {
            Log.d(this.TAG, "computeScroll scrollX:" + this.FCK.getCurrX() + " scrollY:" + this.FCK.getCurrY());
            this.FCM = this.FCK.getCurrX();
            scrollTo(this.FCK.getCurrX(), 0);
            invalidate();
        }
        AppMethodBeat.o(120174);
    }

    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        AppMethodBeat.i(120175);
        Log.d(this.TAG, "onNestedPreScroll dx:" + i2 + " dy:" + i3);
        RecyclerView.LayoutManager layoutManager = this.FCJ.getLayoutManager();
        RecyclerView.a adapter = this.FCJ.getAdapter();
        if (!(layoutManager == null || adapter == null)) {
            if (i2 > 0) {
                if (((LinearLayoutManager) layoutManager).kv() == adapter.getItemCount() - 1) {
                    this.FCM = Math.min(this.FCM + i2, this.plg.getMeasuredWidth() + at.fromDPToPix(getContext(), 20));
                    scrollTo(this.FCM, 0);
                    if (iArr != null) {
                        iArr[0] = i2;
                    }
                }
            } else if (i2 < 0 && getScrollX() != 0) {
                this.FCM = Math.max(this.FCM + i2, 0);
                scrollTo(this.FCM, 0);
                if (iArr != null) {
                    iArr[0] = i2;
                }
            }
            this.FCN = i2;
        }
        AppMethodBeat.o(120175);
    }

    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        return (i2 & 1) != 0;
    }

    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        AppMethodBeat.i(120176);
        Log.d(this.TAG, "onNestedScrollAccepted axes:%s", Integer.valueOf(i2));
        this.FCN = 0;
        this.scrolling = false;
        AppMethodBeat.o(120176);
    }

    public final void onStopNestedScroll(View view) {
        AppMethodBeat.i(120177);
        Log.d(this.TAG, "onStopNestedScroll");
        if (this.FCM != 0) {
            if (this.FCN > 0) {
                fsb();
            } else if (this.FCN < 0) {
                fsc();
            }
        }
        this.FCN = 0;
        this.scrolling = false;
        AppMethodBeat.o(120177);
    }

    public final boolean onNestedPreFling(View view, float f2, float f3) {
        AppMethodBeat.i(120178);
        Log.d(this.TAG, "onNestedPreFling velocityX:" + f2 + " velocityY:" + f3);
        RecyclerView.LayoutManager layoutManager = this.FCJ.getLayoutManager();
        RecyclerView.a adapter = this.FCJ.getAdapter();
        if (!(layoutManager == null || adapter == null)) {
            if (f2 > 0.0f) {
                if (((LinearLayoutManager) layoutManager).kv() == adapter.getItemCount() - 1) {
                    fsb();
                }
            } else if (f2 < 0.0f && getScrollX() != 0) {
                fsc();
            }
        }
        boolean onNestedPreFling = super.onNestedPreFling(view, f2, f3);
        AppMethodBeat.o(120178);
        return onNestedPreFling;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(120179);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getActionMasked()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.deo = motionEvent.getX();
            this.dep = motionEvent.getY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            if (Math.abs(motionEvent.getX() - this.deo) > Math.abs(motionEvent.getY() - this.dep)) {
                requestDisallowInterceptTouchEvent(true);
            }
        } else if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 3)) {
            this.deo = 0.0f;
            this.dep = 0.0f;
        }
        AppMethodBeat.o(120179);
        return dispatchTouchEvent;
    }
}
