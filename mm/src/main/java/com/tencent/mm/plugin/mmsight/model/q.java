package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q {
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
        AppMethodBeat.i(89461);
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
        AppMethodBeat.o(89461);
        return sb2;
    }

    public static q ejT() {
        AppMethodBeat.i(89462);
        q qVar = new q();
        qVar.fps = 30;
        qVar.dYT = 0;
        qVar.ifO = zuQ;
        qVar.ifN = zuP;
        qVar.sUA = zuQ;
        qVar.sUz = zuP;
        qVar.zuR = 327680;
        qVar.zuS = 4;
        qVar.zuT = 1;
        qVar.zuU = "/sdcard/2.yuv";
        qVar.zuY = "/sdcard/2.mp4";
        qVar.zuV = "/sdcard/2.pcm";
        qVar.zuX = "/sdcard/2.x264";
        qVar.zuZ = 0;
        qVar.iFw = 0;
        qVar.zva = 0;
        AppMethodBeat.o(89462);
        return qVar;
    }
}
