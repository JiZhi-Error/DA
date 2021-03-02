package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;

public class VoIPVideoView extends MMTextureView implements TextureView.SurfaceTextureListener {
    private static final int[] Hqr = {452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private int Hqs = 30;
    private int Hqt = 30;
    private int Hqu = 15;
    private float Hqv = 0.02f;
    private Paint qvj;
    private int surfaceHeight;
    private SurfaceTexture surfaceTexture;
    private int surfaceWidth;
    private float tEJ = 0.4f;

    public VoIPVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(115781);
        initView();
        AppMethodBeat.o(115781);
    }

    public VoIPVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(115782);
        initView();
        AppMethodBeat.o(115782);
    }

    private void initView() {
        AppMethodBeat.i(115783);
        this.qvj = new Paint();
        this.qvj.setColor(WebView.NIGHT_MODE_COLOR);
        this.qvj.setFilterBitmap(true);
        this.qvj.setTextSize(40.0f);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(115783);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture2, int i2, int i3) {
        AppMethodBeat.i(115784);
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(surfaceTexture2 != null);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        Log.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureAvailable %b %d %d", objArr);
        this.surfaceTexture = surfaceTexture2;
        this.surfaceWidth = i2;
        this.surfaceHeight = i3;
        gLi();
        AppMethodBeat.o(115784);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture2, int i2, int i3) {
        boolean z;
        AppMethodBeat.i(115785);
        Object[] objArr = new Object[3];
        if (surfaceTexture2 != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        Log.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureSizeChanged %b %d %d", objArr);
        this.surfaceWidth = i2;
        this.surfaceHeight = i3;
        AppMethodBeat.o(115785);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture2) {
        boolean z = true;
        AppMethodBeat.i(115786);
        Object[] objArr = new Object[1];
        if (surfaceTexture2 == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureDestroyed %b", objArr);
        this.surfaceTexture = null;
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        AppMethodBeat.o(115786);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture2) {
        boolean z = true;
        AppMethodBeat.i(115787);
        Object[] objArr = new Object[1];
        if (surfaceTexture2 == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.v("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureUpdated %b", objArr);
        AppMethodBeat.o(115787);
    }
}
