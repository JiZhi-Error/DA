package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 12\u00020\u0001:\u00011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tJ\b\u0010\u001e\u001a\u00020\u001cH\u0002J \u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\b\b\u0002\u0010#\u001a\u00020\tJ\u0006\u0010$\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020\u001cJ\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\tJ\u0010\u0010,\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010!J\u000e\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cancelButton", "Landroid/widget/Button;", "finishButton", "getFinishButton", "()Landroid/widget/Button;", "setFinishButton", "(Landroid/widget/Button;)V", "hasInit", "", "recyclerThumbSeekBar", "Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;", "getRecyclerThumbSeekBar", "()Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;", "setRecyclerThumbSeekBar", "(Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;)V", "root", "changeThumbBarPercent", "", "currentTime", "checkInitThumbSeekBar", "initAsync", "path", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "minDuration", "release", "reset", "setCancelButtonClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setFinishButtonClickListener", "setSeekBarHeight", "h", "setTextColor", "color", "setThumbBarSeekListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Companion", "plugin-recordvideo_release"})
public final class EditVideoSeekBarView extends LinearLayout {
    public static final a BSL = new a((byte) 0);
    boolean hasInit;
    private Button sTL;
    public RecyclerThumbSeekBar zDX;
    private Button zDY;
    private LinearLayout zDZ;

    static {
        AppMethodBeat.i(75714);
        AppMethodBeat.o(75714);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final RecyclerThumbSeekBar getRecyclerThumbSeekBar() {
        return this.zDX;
    }

    public final void setRecyclerThumbSeekBar(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        AppMethodBeat.i(75705);
        p.h(recyclerThumbSeekBar, "<set-?>");
        this.zDX = recyclerThumbSeekBar;
        AppMethodBeat.o(75705);
    }

    public final Button getFinishButton() {
        return this.zDY;
    }

    public final void setFinishButton(Button button) {
        this.zDY = button;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditVideoSeekBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(75712);
        View inflate = aa.jQ(getContext()).inflate(R.layout.c5q, (ViewGroup) this, true);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout");
            AppMethodBeat.o(75712);
            throw tVar;
        }
        this.zDZ = (LinearLayout) inflate;
        View findViewById = findViewById(R.id.j6o);
        p.g(findViewById, "findViewById(R.id.video_thumb_seek_bar)");
        this.zDX = (RecyclerThumbSeekBar) findViewById;
        this.sTL = (Button) findViewById(R.id.bw3);
        this.zDY = (Button) findViewById(R.id.bw6);
        AppMethodBeat.o(75712);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditVideoSeekBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(75713);
        View inflate = aa.jQ(getContext()).inflate(R.layout.c5q, (ViewGroup) this, true);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout");
            AppMethodBeat.o(75713);
            throw tVar;
        }
        this.zDZ = (LinearLayout) inflate;
        View findViewById = findViewById(R.id.j6o);
        p.g(findViewById, "findViewById(R.id.video_thumb_seek_bar)");
        this.zDX = (RecyclerThumbSeekBar) findViewById;
        this.sTL = (Button) findViewById(R.id.bw3);
        this.zDY = (Button) findViewById(R.id.bw6);
        AppMethodBeat.o(75713);
    }

    public final void setSeekBarHeight(int i2) {
        AppMethodBeat.i(75706);
        ViewGroup.LayoutParams layoutParams = this.zDX.getLayoutParams();
        layoutParams.height = i2;
        this.zDX.setLayoutParams(layoutParams);
        AppMethodBeat.o(75706);
    }

    public final void setTextColor(String str) {
        AppMethodBeat.i(75707);
        if (str != null) {
            Button button = this.zDY;
            if (button == null) {
                p.hyc();
            }
            button.setTextColor(Color.parseColor(str));
        }
        AppMethodBeat.o(75707);
    }

    public final void setThumbBarSeekListener(c.b bVar) {
        AppMethodBeat.i(75708);
        p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.zDX.setThumbBarSeekListener(bVar);
        AppMethodBeat.o(75708);
    }

    public final void setFinishButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(75709);
        p.h(onClickListener, "onClickListener");
        Button button = this.zDY;
        if (button == null) {
            p.hyc();
        }
        button.setOnClickListener(onClickListener);
        AppMethodBeat.o(75709);
    }

    public final void setCancelButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(75710);
        p.h(onClickListener, "onClickListener");
        Button button = this.sTL;
        if (button == null) {
            p.hyc();
        }
        button.setOnClickListener(onClickListener);
        AppMethodBeat.o(75710);
    }

    public final void release() {
        AppMethodBeat.i(75711);
        this.hasInit = false;
        this.zDX.release();
        ViewParent parent = this.zDX.getParent();
        if (parent instanceof LinearLayout) {
            ViewGroup.LayoutParams layoutParams = this.zDX.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                AppMethodBeat.o(75711);
                throw tVar;
            }
            ((LinearLayout) parent).removeView(this.zDX);
            this.zDX = new RecyclerThumbSeekBar(getContext());
            ((LinearLayout) parent).addView(this.zDX, 0, (LinearLayout.LayoutParams) layoutParams);
        }
        AppMethodBeat.o(75711);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "error", "", "onPrepared"})
    public static final class b implements c.a {
        public static final b BSM = new b();

        static {
            AppMethodBeat.i(75704);
            AppMethodBeat.o(75704);
        }

        b() {
        }

        @Override // com.tencent.mm.plugin.mmsight.segment.c.a
        public final void ri(boolean z) {
            AppMethodBeat.i(75703);
            if (z) {
                Log.e("MicroMsg.VideoSeekBarEditorView", "Not Supported init SegmentSeekBar failed.");
                AppMethodBeat.o(75703);
                return;
            }
            AppMethodBeat.o(75703);
        }
    }
}
