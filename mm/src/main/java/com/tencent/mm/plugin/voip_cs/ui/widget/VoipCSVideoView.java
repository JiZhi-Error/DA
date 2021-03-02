package com.tencent.mm.plugin.voip_cs.ui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;

public class VoipCSVideoView extends MMTextureView implements TextureView.SurfaceTextureListener {
    private static final int[] Hqr = {452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private a HsG = a.None;
    private int index;
    private int position;
    private Paint qvj;
    private int surfaceHeight;
    private SurfaceTexture surfaceTexture;
    private int surfaceWidth;
    private String username;

    public VoipCSVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(125480);
        initView();
        AppMethodBeat.o(125480);
    }

    public VoipCSVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(125481);
        initView();
        AppMethodBeat.o(125481);
    }

    private void initView() {
        AppMethodBeat.i(125482);
        this.qvj = new Paint();
        this.qvj.setColor(WebView.NIGHT_MODE_COLOR);
        this.qvj.setFilterBitmap(true);
        this.qvj.setTextSize(40.0f);
        setSurfaceTextureListener(this);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), getWidth(), getHeight());
        }
        AppMethodBeat.o(125482);
    }

    public String getUsername() {
        return this.username;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i2) {
        this.index = i2;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public int getPosition() {
        return this.position;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture2, int i2, int i3) {
        boolean z = false;
        AppMethodBeat.i(125483);
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture2 != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        Log.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureAvailable %s %b %d %d", objArr);
        AppMethodBeat.o(125483);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture2, int i2, int i3) {
        boolean z = false;
        AppMethodBeat.i(125484);
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture2 != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        Log.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureSizeChanged %s %b %d %d", objArr);
        AppMethodBeat.o(125484);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture2) {
        boolean z;
        AppMethodBeat.i(125485);
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture2 != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureDestroyed %s %b", objArr);
        this.surfaceTexture = null;
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        AppMethodBeat.o(125485);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture2) {
        boolean z = false;
        AppMethodBeat.i(125486);
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture2 != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.v("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureUpdated %s %b", objArr);
        AppMethodBeat.o(125486);
    }

    public enum a {
        Avatar,
        Video,
        None;

        public static a valueOf(String str) {
            AppMethodBeat.i(125478);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(125478);
            return aVar;
        }

        static {
            AppMethodBeat.i(125479);
            AppMethodBeat.o(125479);
        }
    }
}
