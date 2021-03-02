package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.n.n;

public final class MusicLrcView extends TextView {
    public static final a Cee = new a((byte) 0);
    private boolean Cak;
    private int Cec;
    private int Ced;
    private final int foregroundColor;
    private v hWJ;
    private Scroller mScroller;
    private int wDQ;
    private boolean wDR;

    static {
        AppMethodBeat.i(237742);
        AppMethodBeat.o(237742);
    }

    public MusicLrcView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private /* synthetic */ MusicLrcView(Context context, AttributeSet attributeSet, byte b2) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicLrcView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(76042);
        this.Cec = 10000;
        this.wDQ = -getWidth();
        this.wDR = true;
        this.foregroundColor = com.tencent.mm.cb.a.n(context, R.color.acr);
        AppMethodBeat.o(76042);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static CharSequence a(String str, CharSequence charSequence, int i2) {
            int i3;
            AppMethodBeat.i(237738);
            p.h(str, "source");
            SpannableString spannableString = new SpannableString(str);
            if (charSequence == null || charSequence.length() == 0) {
                SpannableString spannableString2 = spannableString;
                AppMethodBeat.o(237738);
                return spannableString2;
            }
            int length = charSequence.length();
            int i4 = 0;
            while (true) {
                int a2 = n.a((CharSequence) str, charSequence.toString(), i4, false);
                if (a2 != -1) {
                    i3 = a2 + length + i4;
                    spannableString.setSpan(new ForegroundColorSpan(i2), a2, a2 + length, 33);
                } else {
                    i3 = i4;
                }
                if (a2 == -1) {
                    SpannableString spannableString3 = spannableString;
                    AppMethodBeat.o(237738);
                    return spannableString3;
                }
                i4 = i3;
            }
        }
    }

    public final v getPlayer() {
        return this.hWJ;
    }

    public final void setPlayer(v vVar) {
        AppMethodBeat.i(76033);
        if (vVar != null) {
            this.hWJ = vVar;
            v vVar2 = this.hWJ;
            if (vVar2 != null) {
                vVar2.a(new b(this));
                AppMethodBeat.o(76033);
                return;
            }
        }
        AppMethodBeat.o(76033);
    }

    public static final class b implements q.a {
        final /* synthetic */ MusicLrcView Cef;

        b(MusicLrcView musicLrcView) {
            this.Cef = musicLrcView;
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void b(com.google.android.exoplayer2.p pVar) {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void tz() {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void a(e eVar) {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void aR(boolean z) {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void tA() {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void aA(int i2) {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void ty() {
        }

        @Override // com.google.android.exoplayer2.q.a
        public final void c(boolean z, int i2) {
            Long l = null;
            AppMethodBeat.i(76031);
            if (i2 == 3) {
                MusicLrcView.a(this.Cef);
                v player = this.Cef.getPlayer();
                Long valueOf = player != null ? Long.valueOf(player.getDuration()) : null;
                if (valueOf == null) {
                    p.hyc();
                }
                if (valueOf.longValue() < ((long) this.Cef.getRndDuration())) {
                    MusicLrcView musicLrcView = this.Cef;
                    v player2 = this.Cef.getPlayer();
                    if (player2 != null) {
                        l = Long.valueOf(player2.getDuration());
                    }
                    if (l == null) {
                        p.hyc();
                    }
                    musicLrcView.setRndDuration((int) l.longValue());
                }
            }
            AppMethodBeat.o(76031);
        }
    }

    public final void setRunningShow(boolean z) {
        this.Cak = z;
    }

    public final int getRndDuration() {
        return this.Cec;
    }

    public final void setRndDuration(int i2) {
        this.Cec = i2;
    }

    public final int getScrollFirstDelay() {
        return this.Ced;
    }

    public final void setScrollFirstDelay(int i2) {
        this.Ced = i2;
    }

    public static /* synthetic */ void a(MusicLrcView musicLrcView) {
        AppMethodBeat.i(237741);
        musicLrcView.eMf();
        AppMethodBeat.o(237741);
    }

    private void eMf() {
        AppMethodBeat.i(237740);
        if (this.Cak) {
            this.wDQ = getWidth();
            this.wDR = true;
            eMg();
        }
        AppMethodBeat.o(237740);
    }

    private void eMg() {
        AppMethodBeat.i(76036);
        if (!this.Cak) {
            AppMethodBeat.o(76036);
            return;
        }
        setHorizontallyScrolling(true);
        if (this.mScroller == null) {
            this.mScroller = new Scroller(getContext(), new LinearInterpolator());
            setScroller(this.mScroller);
        }
        int eMh = eMh();
        int i2 = eMh - ((this.wDQ * 3) / 4);
        if (i2 != 0) {
            int i3 = (this.Cec * i2) / eMh;
            if (this.wDR) {
                postDelayed(new c(this, i2, i3), (long) this.Ced);
                AppMethodBeat.o(76036);
                return;
            }
            Scroller scroller = this.mScroller;
            if (scroller == null) {
                p.hyc();
            }
            scroller.startScroll(this.wDQ, 0, i2, 0, i3);
            invalidate();
        }
        AppMethodBeat.o(76036);
    }

    public static final class c implements Runnable {
        final /* synthetic */ MusicLrcView Cef;
        final /* synthetic */ int Ceg;
        final /* synthetic */ int tAM;

        c(MusicLrcView musicLrcView, int i2, int i3) {
            this.Cef = musicLrcView;
            this.tAM = i2;
            this.Ceg = i3;
        }

        public final void run() {
            AppMethodBeat.i(76032);
            Scroller scroller = this.Cef.mScroller;
            if (scroller == null) {
                p.hyc();
            }
            scroller.startScroll(this.Cef.wDQ, 0, this.tAM, 0, this.Ceg);
            this.Cef.invalidate();
            AppMethodBeat.o(76032);
        }
    }

    public static /* synthetic */ void a(MusicLrcView musicLrcView, ArrayList arrayList) {
        AppMethodBeat.i(76038);
        musicLrcView.f(arrayList, null);
        AppMethodBeat.o(76038);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(java.util.ArrayList<com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.c> r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView.f(java.util.ArrayList, java.lang.String):void");
    }

    private final int eMh() {
        AppMethodBeat.i(76040);
        TextPaint paint = getPaint();
        Rect rect = new Rect();
        String obj = getText().toString();
        paint.getTextBounds(obj, 0, obj.length(), rect);
        if (rect.width() > 0) {
            int width = rect.width();
            AppMethodBeat.o(76040);
            return width;
        }
        int width2 = getWidth();
        AppMethodBeat.o(76040);
        return width2;
    }

    public final void computeScroll() {
        AppMethodBeat.i(76041);
        super.computeScroll();
        if (this.mScroller == null) {
            AppMethodBeat.o(76041);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller == null) {
            p.hyc();
        }
        if (scroller.isFinished()) {
            this.wDQ = -getWidth();
            this.wDR = false;
            eMg();
        }
        AppMethodBeat.o(76041);
    }

    public static /* synthetic */ void a(MusicLrcView musicLrcView, boolean z) {
        AppMethodBeat.i(237739);
        musicLrcView.Cak = z;
        if (!musicLrcView.Cak) {
            if (musicLrcView.mScroller != null) {
                Scroller scroller = musicLrcView.mScroller;
                if (scroller == null) {
                    p.hyc();
                }
                scroller.startScroll(0, 0, 0, 0, 0);
            }
            AppMethodBeat.o(237739);
            return;
        }
        musicLrcView.eMf();
        AppMethodBeat.o(237739);
    }
}
