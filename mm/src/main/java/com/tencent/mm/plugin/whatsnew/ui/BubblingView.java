package com.tencent.mm.plugin.whatsnew.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.ui.view.d;
import java.util.Random;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/BubblingView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bubbleImg", "Landroid/widget/ImageView;", "onBubblingViewClickListener", "Lcom/tencent/mm/plugin/whatsnew/ui/BubblingView$OnBubblingViewClickListener;", "getOnBubblingViewClickListener", "()Lcom/tencent/mm/plugin/whatsnew/ui/BubblingView$OnBubblingViewClickListener;", "setOnBubblingViewClickListener", "(Lcom/tencent/mm/plugin/whatsnew/ui/BubblingView$OnBubblingViewClickListener;)V", "smallConfetti", "Lcom/tencent/mm/particles/ConfettiManager;", "smallGenerator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "emitSmallBubble", "", "stopSmallBubble", "Companion", "OnBubblingViewClickListener", "app_release"})
public final class BubblingView extends RelativeLayout {
    public static final a JOG = new a((byte) 0);
    private static final String TAG = TAG;
    private final com.tencent.mm.particles.b FCt;
    private final ImageView JOE;
    private b JOF;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/BubblingView$OnBubblingViewClickListener;", "", "onBubblingViewClick", "", "app_release"})
    public interface b {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BubblingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(230947);
        View.inflate(context, R.layout.ls, this);
        View findViewById = findViewById(R.id.afd);
        p.g(findViewById, "findViewById(R.id.bubble_img)");
        this.JOE = (ImageView) findViewById;
        this.JOE.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.whatsnew.ui.BubblingView.AnonymousClass1 */
            final /* synthetic */ BubblingView JOH;

            {
                this.JOH = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(230945);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/whatsnew/ui/BubblingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.JOH.getOnBubblingViewClickListener();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/whatsnew/ui/BubblingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(230945);
            }
        });
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bvn);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 40);
        final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, fromDPToPix, fromDPToPix, true);
        this.FCt = new com.tencent.mm.particles.b() {
            /* class com.tencent.mm.plugin.whatsnew.ui.BubblingView.AnonymousClass2 */

            @Override // com.tencent.mm.particles.b
            public final /* synthetic */ com.tencent.mm.particles.a.b a(Random random) {
                AppMethodBeat.i(230946);
                Bitmap bitmap = createScaledBitmap;
                p.g(bitmap, "scaled");
                d dVar = new d(bitmap);
                AppMethodBeat.o(230946);
                return dVar;
            }
        };
        AppMethodBeat.o(230947);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BubblingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(230948);
        AppMethodBeat.o(230948);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/BubblingView$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(230949);
        AppMethodBeat.o(230949);
    }

    public final b getOnBubblingViewClickListener() {
        return this.JOF;
    }

    public final void setOnBubblingViewClickListener(b bVar) {
        this.JOF = bVar;
    }
}
