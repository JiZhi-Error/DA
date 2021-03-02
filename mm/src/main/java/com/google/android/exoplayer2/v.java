package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.a.b;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.f.j;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.source.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public final class v implements f {
    private final f bcC;
    protected final r[] bcc;
    private final a bdR = new a(this, (byte) 0);
    final CopyOnWriteArraySet<Object> bdS = new CopyOnWriteArraySet<>();
    final CopyOnWriteArraySet<j.a> bdT = new CopyOnWriteArraySet<>();
    public final CopyOnWriteArraySet<e.a> bdU = new CopyOnWriteArraySet<>();
    private final int bdV;
    private final int bdW;
    Format bdX;
    Format bdY;
    private boolean bdZ;
    private int bea;
    private SurfaceHolder beb;
    private TextureView bec;
    public com.google.android.exoplayer2.a.e bed;
    com.google.android.exoplayer2.video.e bee;
    d bef;
    d beg;
    int beh;
    private b bei;
    private float bej;
    Surface surface;

    static /* synthetic */ void a(v vVar, Surface surface2, boolean z) {
        AppMethodBeat.i(92559);
        vVar.a(surface2, z);
        AppMethodBeat.o(92559);
    }

    protected v(u uVar, h hVar, m mVar) {
        AppMethodBeat.i(92534);
        this.bcc = uVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.bdR, this.bdR, this.bdR, this.bdR);
        int i2 = 0;
        int i3 = 0;
        for (r rVar : this.bcc) {
            switch (rVar.getTrackType()) {
                case 1:
                    i2++;
                    break;
                case 2:
                    i3++;
                    break;
            }
        }
        this.bdV = i3;
        this.bdW = i2;
        this.bej = 1.0f;
        this.beh = 0;
        this.bei = b.beJ;
        this.bea = 1;
        this.bcC = new h(this.bcc, hVar, mVar);
        AppMethodBeat.o(92534);
    }

    public final void c(TextureView textureView) {
        SurfaceTexture surfaceTexture;
        Surface surface2 = null;
        AppMethodBeat.i(196037);
        tC();
        this.bec = textureView;
        if (textureView != null) {
            textureView.getSurfaceTextureListener();
            textureView.setSurfaceTextureListener(this.bdR);
            if (textureView.isAvailable()) {
                surfaceTexture = textureView.getSurfaceTexture();
            } else {
                surfaceTexture = null;
            }
            if (surfaceTexture != null) {
                surface2 = new Surface(surfaceTexture);
            }
        }
        a(surface2, true);
        AppMethodBeat.o(196037);
    }

    @Override // com.google.android.exoplayer2.q
    public final void a(q.a aVar) {
        AppMethodBeat.i(92539);
        this.bcC.a(aVar);
        AppMethodBeat.o(92539);
    }

    @Override // com.google.android.exoplayer2.q
    public final void b(q.a aVar) {
        AppMethodBeat.i(92540);
        this.bcC.b(aVar);
        AppMethodBeat.o(92540);
    }

    @Override // com.google.android.exoplayer2.q
    public final int ti() {
        AppMethodBeat.i(92541);
        int ti = this.bcC.ti();
        AppMethodBeat.o(92541);
        return ti;
    }

    @Override // com.google.android.exoplayer2.f
    public final void a(k kVar) {
        AppMethodBeat.i(92542);
        this.bcC.a(kVar);
        AppMethodBeat.o(92542);
    }

    @Override // com.google.android.exoplayer2.q
    public final void aO(boolean z) {
        AppMethodBeat.i(92543);
        this.bcC.aO(z);
        AppMethodBeat.o(92543);
    }

    @Override // com.google.android.exoplayer2.q
    public final boolean tj() {
        AppMethodBeat.i(92544);
        boolean tj = this.bcC.tj();
        AppMethodBeat.o(92544);
        return tj;
    }

    @Override // com.google.android.exoplayer2.q
    public final void setRepeatMode(int i2) {
        AppMethodBeat.i(92545);
        this.bcC.setRepeatMode(i2);
        AppMethodBeat.o(92545);
    }

    @Override // com.google.android.exoplayer2.q
    public final boolean isLoading() {
        AppMethodBeat.i(92546);
        boolean isLoading = this.bcC.isLoading();
        AppMethodBeat.o(92546);
        return isLoading;
    }

    @Override // com.google.android.exoplayer2.q
    public final void seekTo(long j2) {
        AppMethodBeat.i(92547);
        this.bcC.seekTo(j2);
        AppMethodBeat.o(92547);
    }

    @Override // com.google.android.exoplayer2.q
    public final void a(p pVar) {
        AppMethodBeat.i(92548);
        this.bcC.a(pVar);
        AppMethodBeat.o(92548);
    }

    @Override // com.google.android.exoplayer2.q
    public final void stop() {
        AppMethodBeat.i(92549);
        this.bcC.stop();
        AppMethodBeat.o(92549);
    }

    @Override // com.google.android.exoplayer2.q
    public final void release() {
        AppMethodBeat.i(92550);
        this.bcC.release();
        tC();
        if (this.surface != null) {
            if (this.bdZ) {
                this.surface.release();
            }
            this.surface = null;
        }
        AppMethodBeat.o(92550);
    }

    @Override // com.google.android.exoplayer2.f
    public final void a(f.c... cVarArr) {
        AppMethodBeat.i(92551);
        this.bcC.a(cVarArr);
        AppMethodBeat.o(92551);
    }

    @Override // com.google.android.exoplayer2.f
    public final void b(f.c... cVarArr) {
        AppMethodBeat.i(92552);
        this.bcC.b(cVarArr);
        AppMethodBeat.o(92552);
    }

    @Override // com.google.android.exoplayer2.q
    public final long getDuration() {
        AppMethodBeat.i(92553);
        long duration = this.bcC.getDuration();
        AppMethodBeat.o(92553);
        return duration;
    }

    @Override // com.google.android.exoplayer2.q
    public final long getCurrentPosition() {
        AppMethodBeat.i(92554);
        long currentPosition = this.bcC.getCurrentPosition();
        AppMethodBeat.o(92554);
        return currentPosition;
    }

    @Override // com.google.android.exoplayer2.q
    public final long getBufferedPosition() {
        AppMethodBeat.i(92555);
        long bufferedPosition = this.bcC.getBufferedPosition();
        AppMethodBeat.o(92555);
        return bufferedPosition;
    }

    @Override // com.google.android.exoplayer2.q
    public final int getBufferedPercentage() {
        AppMethodBeat.i(92556);
        int bufferedPercentage = this.bcC.getBufferedPercentage();
        AppMethodBeat.o(92556);
        return bufferedPercentage;
    }

    private void tC() {
        AppMethodBeat.i(92557);
        if (this.bec != null) {
            if (this.bec.getSurfaceTextureListener() == this.bdR) {
                this.bec.setSurfaceTextureListener(null);
            }
            this.bec = null;
        }
        if (this.beb != null) {
            this.beb.removeCallback(this.bdR);
            this.beb = null;
        }
        AppMethodBeat.o(92557);
    }

    private void a(Surface surface2, boolean z) {
        int i2;
        AppMethodBeat.i(92558);
        f.c[] cVarArr = new f.c[this.bdV];
        r[] rVarArr = this.bcc;
        int length = rVarArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            r rVar = rVarArr[i3];
            if (rVar.getTrackType() == 2) {
                i2 = i4 + 1;
                cVarArr[i4] = new f.c(rVar, 1, surface2);
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        if (this.surface == null || this.surface == surface2) {
            this.bcC.a(cVarArr);
        } else {
            this.bcC.b(cVarArr);
            if (this.bdZ) {
                this.surface.release();
            }
        }
        this.surface = surface2;
        this.bdZ = z;
        AppMethodBeat.o(92558);
    }

    /* access modifiers changed from: package-private */
    public final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e {
        private a() {
        }

        /* synthetic */ a(v vVar, byte b2) {
            this();
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void a(d dVar) {
            AppMethodBeat.i(92515);
            v.this.bef = dVar;
            if (v.this.bee != null) {
                v.this.bee.a(dVar);
            }
            AppMethodBeat.o(92515);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void b(String str, long j2, long j3) {
            AppMethodBeat.i(92516);
            if (v.this.bee != null) {
                v.this.bee.b(str, j2, j3);
            }
            AppMethodBeat.o(92516);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void c(Format format) {
            AppMethodBeat.i(92517);
            v.this.bdX = format;
            if (v.this.bee != null) {
                v.this.bee.c(format);
            }
            AppMethodBeat.o(92517);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void h(int i2, long j2) {
            AppMethodBeat.i(92518);
            if (v.this.bee != null) {
                v.this.bee.h(i2, j2);
            }
            AppMethodBeat.o(92518);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void a(int i2, int i3, int i4, float f2) {
            AppMethodBeat.i(92519);
            Iterator<Object> it = v.this.bdS.iterator();
            while (it.hasNext()) {
                it.next();
            }
            if (v.this.bee != null) {
                v.this.bee.a(i2, i3, i4, f2);
            }
            AppMethodBeat.o(92519);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void c(Surface surface) {
            AppMethodBeat.i(92520);
            if (v.this.surface == surface) {
                Iterator<Object> it = v.this.bdS.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            if (v.this.bee != null) {
                v.this.bee.c(surface);
            }
            AppMethodBeat.o(92520);
        }

        @Override // com.google.android.exoplayer2.video.e
        public final void b(d dVar) {
            AppMethodBeat.i(92521);
            if (v.this.bee != null) {
                v.this.bee.b(dVar);
            }
            v.this.bdX = null;
            v.this.bef = null;
            AppMethodBeat.o(92521);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void c(d dVar) {
            AppMethodBeat.i(92522);
            v.this.beg = dVar;
            if (v.this.bed != null) {
                v.this.bed.c(dVar);
            }
            AppMethodBeat.o(92522);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void dG(int i2) {
            AppMethodBeat.i(92523);
            v.this.beh = i2;
            if (v.this.bed != null) {
                v.this.bed.dG(i2);
            }
            AppMethodBeat.o(92523);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void c(String str, long j2, long j3) {
            AppMethodBeat.i(92524);
            if (v.this.bed != null) {
                v.this.bed.c(str, j2, j3);
            }
            AppMethodBeat.o(92524);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void d(Format format) {
            AppMethodBeat.i(92525);
            v.this.bdY = format;
            if (v.this.bed != null) {
                v.this.bed.d(format);
            }
            AppMethodBeat.o(92525);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void d(int i2, long j2, long j3) {
            AppMethodBeat.i(92526);
            if (v.this.bed != null) {
                v.this.bed.d(i2, j2, j3);
            }
            AppMethodBeat.o(92526);
        }

        @Override // com.google.android.exoplayer2.a.e
        public final void d(d dVar) {
            AppMethodBeat.i(92527);
            if (v.this.bed != null) {
                v.this.bed.d(dVar);
            }
            v.this.bdY = null;
            v.this.beg = null;
            v.this.beh = 0;
            AppMethodBeat.o(92527);
        }

        @Override // com.google.android.exoplayer2.f.j.a
        public final void s(List<com.google.android.exoplayer2.f.a> list) {
            AppMethodBeat.i(92528);
            Iterator<j.a> it = v.this.bdT.iterator();
            while (it.hasNext()) {
                it.next().s(list);
            }
            AppMethodBeat.o(92528);
        }

        @Override // com.google.android.exoplayer2.metadata.e.a
        public final void b(Metadata metadata) {
            AppMethodBeat.i(92529);
            Iterator<e.a> it = v.this.bdU.iterator();
            while (it.hasNext()) {
                it.next().b(metadata);
            }
            AppMethodBeat.o(92529);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(92530);
            v.a(v.this, surfaceHolder.getSurface(), false);
            AppMethodBeat.o(92530);
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(92531);
            v.a(v.this, null, false);
            AppMethodBeat.o(92531);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(92532);
            v.a(v.this, new Surface(surfaceTexture), true);
            AppMethodBeat.o(92532);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(92533);
            v.a(v.this, null, true);
            AppMethodBeat.o(92533);
            return true;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
