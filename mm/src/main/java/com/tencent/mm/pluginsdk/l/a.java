package com.tencent.mm.pluginsdk.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a {
    public static int zuP = 480;
    public static int zuQ = 640;
    public int dYT;
    public int fps;
    public int iFw;
    public int ifN;
    public int ifO;
    public int sUA;
    public int sUz;
    public int zuR;
    public int zuS;
    public int zuT;
    public String zuU;
    public String zuV;
    public String zuW;
    public String zuX;
    public String zuY;
    public int zuZ;
    public int zva;

    public final String toString() {
        AppMethodBeat.i(31162);
        StringBuilder sb = new StringBuilder();
        sb.append("fps=").append(this.fps).append('\n');
        sb.append("width=").append(this.sUz).append('\n');
        sb.append("height=").append(this.sUA).append('\n');
        sb.append("bitrate=").append(this.zuR).append('\n');
        sb.append("rotate=").append(this.dYT).append('\n');
        sb.append("yuvWidth=").append(this.ifN).append('\n');
        sb.append("yuvHeight=").append(this.ifO).append('\n');
        sb.append("x264Speed=").append(this.zuS).append('\n');
        sb.append("x264Quality=").append(this.zuT).append('\n');
        sb.append("yuvFile=").append(this.zuU).append('\n');
        sb.append("pcmFile=").append(this.zuV).append('\n');
        sb.append("thuFile=").append(this.zuW).append('\n');
        sb.append("x264File=").append(this.zuX).append('\n');
        sb.append("mp4File=").append(this.zuY).append('\n');
        sb.append("videoFrameCnt=").append(this.zuZ).append('\n');
        sb.append("videoLength=").append(this.iFw).append('\n');
        sb.append("cameraCount=").append(this.zva).append('\n');
        String sb2 = sb.toString();
        AppMethodBeat.o(31162);
        return sb2;
    }

    public static a gog() {
        AppMethodBeat.i(31163);
        a aVar = new a();
        aVar.fps = 30;
        aVar.dYT = 0;
        aVar.ifO = 640;
        aVar.ifN = 480;
        aVar.sUA = 640;
        aVar.sUz = 480;
        aVar.zuR = 1440000;
        aVar.zuS = 1;
        aVar.zuT = 4;
        aVar.zuU = "/sdcard/1.yuv";
        aVar.zuY = "/sdcard/1.mp4";
        aVar.zuV = "/sdcard/1.pcm";
        aVar.zuX = "/sdcard/1.x264";
        aVar.zuZ = 0;
        aVar.iFw = 0;
        aVar.zva = 0;
        AppMethodBeat.o(31163);
        return aVar;
    }

    public static a goh() {
        AppMethodBeat.i(31164);
        a aVar = new a();
        aVar.fps = 30;
        aVar.dYT = 0;
        aVar.ifO = zuQ;
        aVar.ifN = zuP;
        aVar.sUA = zuQ;
        aVar.sUz = zuP;
        aVar.zuR = 327680;
        aVar.zuS = 4;
        aVar.zuT = 1;
        aVar.zuU = "/sdcard/2.yuv";
        aVar.zuY = "/sdcard/2.mp4";
        aVar.zuV = "/sdcard/2.pcm";
        aVar.zuX = "/sdcard/2.x264";
        aVar.zuZ = 0;
        aVar.iFw = 0;
        aVar.zva = 0;
        AppMethodBeat.o(31164);
        return aVar;
    }
}
