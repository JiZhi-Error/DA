package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g {
    public String kMX;
    String lAo;
    public boolean lBG;
    boolean lCY;
    public String mAppId;
    int mDownloadType;
    String mFileName;
    long mFileSize;
    String mPackageName;
    int mScene;
    String qIE;
    String qIF;
    int qIG;
    public boolean qIH;
    public boolean qII;
    boolean qIJ;
    private boolean qIK;
    public boolean qIL;
    boolean qIM;
    boolean qIN;
    boolean qIO;
    boolean qIP;
    int qIQ;
    int qIR;
    int qIS;
    LinkedList<com.tencent.mm.plugin.downloader.c.b.a> qIT;
    public String qIU;
    boolean qIV;
    String qIW;
    String qIX;

    /* synthetic */ g(byte b2) {
        this();
    }

    private g() {
        this.kMX = "";
        this.qIE = "";
        this.mFileSize = 0;
        this.mFileName = "";
        this.qIF = "";
        this.qIG = 1;
        this.mAppId = "";
        this.mPackageName = "";
        this.qIH = false;
        this.lCY = true;
        this.qII = false;
        this.qIJ = false;
        this.mScene = 0;
        this.qIK = false;
        this.qIL = false;
        this.lBG = false;
        this.qIM = false;
        this.qIN = false;
        this.qIO = false;
        this.qIP = false;
        this.qIQ = 0;
        this.qIR = 0;
        this.qIS = 0;
        this.mDownloadType = 1;
    }

    public static final class a {
        public g qIY = new g((byte) 0);

        public a() {
            AppMethodBeat.i(89007);
            AppMethodBeat.o(89007);
        }

        public final void alj(String str) {
            this.qIY.kMX = str;
        }

        public final void alk(String str) {
            this.qIY.qIE = str;
        }

        public final void setFileSize(long j2) {
            this.qIY.mFileSize = j2;
        }

        public final void all(String str) {
            this.qIY.mFileName = str;
        }

        public final void setFileMD5(String str) {
            this.qIY.qIF = str;
        }

        public final void setAppId(String str) {
            this.qIY.mAppId = str;
        }

        public final void Fl(int i2) {
            this.qIY.qIG = i2;
        }

        public final void kS(boolean z) {
            this.qIY.qIH = z;
        }

        public final void kT(boolean z) {
            this.qIY.lCY = z;
        }

        public final void gm(String str) {
            this.qIY.mPackageName = str;
        }

        public final void kU(boolean z) {
            this.qIY.qIJ = z;
        }

        public final void setScene(int i2) {
            this.qIY.mScene = i2;
        }

        public final void kV(boolean z) {
            this.qIY.lBG = z;
        }

        public final void cBD() {
            this.qIY.qIM = true;
        }

        public final void Rv(String str) {
            this.qIY.lAo = str;
        }

        public final void cBE() {
            this.qIY.qIO = true;
        }

        public final void cBF() {
            this.qIY.qIP = true;
        }

        public final void Fm(int i2) {
            this.qIY.qIQ = i2;
        }

        public final void Fn(int i2) {
            this.qIY.qIS = i2;
        }

        public final void Fo(int i2) {
            this.qIY.qIR = i2;
        }

        public final void Fp(int i2) {
            this.qIY.mDownloadType = i2;
        }

        public final void V(LinkedList<com.tencent.mm.plugin.downloader.c.b.a> linkedList) {
            this.qIY.qIT = linkedList;
        }

        public final void alm(String str) {
            this.qIY.qIU = str;
        }

        public final g cBG() {
            return this.qIY;
        }

        public final void cBH() {
            this.qIY.qIV = true;
        }

        public final void aln(String str) {
            this.qIY.qIW = str;
        }

        public final void alo(String str) {
            this.qIY.qIX = str;
        }
    }
}
