package com.tencent.thumbplayer.core.player;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPNativePlayerSurfaceRenderInfo {
    public int displayHeight = -1;
    public int displayWidth = -1;
    public TPVideoCropInfo videoCropInfo = null;

    public static class TPVideoCropInfo {
        public int cropBottom = -1;
        public int cropLeft = -1;
        public int cropRight = -1;
        public int cropTop = -1;
        public int height = -1;
        public int width = -1;

        public String toString() {
            AppMethodBeat.i(189992);
            String str = "width:" + this.width + ", height:" + this.height + ", cropLeft:" + this.cropLeft + ", cropRight:" + this.cropRight + ", cropTop:" + this.cropTop + ", cropBottom:" + this.cropBottom;
            AppMethodBeat.o(189992);
            return str;
        }
    }
}
