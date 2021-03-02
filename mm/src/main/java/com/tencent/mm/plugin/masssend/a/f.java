package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.vfs.s;
import com.tencent.ugc.TXRecordCommon;
import junit.framework.Assert;

public final class f extends q implements m {
    private i callback;
    f.a hvh;
    private int iXp;
    boolean ifz;
    int jsp;
    int retCode;
    public d rr;
    private a znu;

    public f(a aVar, boolean z) {
        this(aVar, z, 0);
    }

    public f(a aVar, boolean z, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(26360);
        this.znu = null;
        this.hvh = null;
        this.retCode = 0;
        this.jsp = 0;
        this.ifz = false;
        this.znu = aVar;
        this.iXp = i2;
        aVar.createTime = Util.nowMilliSecond();
        if (aVar.msgType == 43) {
            aVar.status = 104;
            o.bhj();
            aVar.znq = t.Qy(t.Qx(aVar.ehx()));
            o.bhj();
            aVar.djh = t.Qy(t.Qw(aVar.ehx()));
            this.jsp = 2500;
            if (aVar.videoSource == 2) {
                this.jsp = 2500;
            }
        } else if (aVar.msgType == 34) {
            this.jsp = 40;
            aVar.status = 104;
            aVar.djh = com.tencent.mm.modelvoice.q.Qy(aVar.ehx());
            aVar.znq = 0;
        } else if (aVar.msgType == 3) {
            this.jsp = 40;
            if (i2 == 1) {
                this.jsp = 1250;
                i3 = 1;
            } else {
                i3 = 0;
            }
            aVar.znr = i3;
            aVar.status = 104;
            aVar.znq = 0;
            StringBuilder sb = new StringBuilder();
            bg.aVF();
            aVar.djh = (int) s.boW(sb.append(c.aSY()).append(aVar.ehx()).toString());
        } else if (aVar.msgType == 1) {
            this.jsp = 1;
            aVar.status = 104;
            aVar.djh = aVar.ehx().getBytes().length;
            aVar.znq = 0;
        } else {
            Log.d("MicroMsg.NetSceneMasSend", "error msgtype:" + aVar.msgType);
            Assert.assertTrue("error msgtype:" + aVar.msgType, false);
        }
        d.a aVar2 = new d.a();
        aVar2.iLN = new cmp();
        aVar2.iLO = new cmq();
        aVar2.uri = "/cgi-bin/micromsg-bin/masssend";
        aVar2.funcId = 193;
        aVar2.iLP = 84;
        aVar2.respCmdId = 1000000084;
        this.rr = aVar2.aXF();
        cmp cmp = (cmp) this.rr.iLK.iLR;
        cmp.MrN = g.getMessageDigest(aVar.ehz().getBytes());
        cmp.MrY = aVar.znn;
        cmp.MrM = aVar.ehz();
        aVar.jlz = new StringBuilder().append(Util.nowMilliSecond()).toString();
        cmp.MrO = aVar.ehw();
        cmp.xKb = aVar.msgType;
        cmp.MrP = aVar.zno;
        cmp.MrZ = !z ? 0 : i4;
        cmp.LYt = i2;
        this.hvh = new f.a();
        AppMethodBeat.o(26360);
    }

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        this.ifz = true;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        int i2;
        boolean z = false;
        AppMethodBeat.i(26361);
        this.callback = iVar;
        if (this.ifz) {
            Log.d("MicroMsg.NetSceneMasSend", "isCancel");
            this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(26361);
            return -1;
        }
        this.jsp--;
        if (this.jsp < 0) {
            Log.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
            this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(26361);
            return -1;
        } else if (this.znu == null) {
            Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
            this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(26361);
            return -1;
        } else if (Util.isNullOrNil(this.znu.ehz())) {
            Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
            this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(26361);
            return -1;
        } else if (this.znu.znn == 0) {
            Log.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(26361);
            return -1;
        } else if (this.znu.djh <= 0) {
            Log.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(26361);
            return -1;
        } else if (this.znu.status == 103 && this.znu.znq <= 0) {
            Log.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(26361);
            return -1;
        } else if (this.znu.status == 103 || this.znu.status == 104) {
            cmp cmp = (cmp) this.rr.iLK.iLR;
            if (this.znu.msgType == 43) {
                String ehx = this.znu.ehx();
                if (Util.isNullOrNil(ehx)) {
                    Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
                    this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                    i2 = -1;
                } else {
                    cmp.MrQ = new SKBuiltinBuffer_t();
                    cmp.MrR = 0;
                    cmp.MrV = new SKBuiltinBuffer_t();
                    cmp.MrU = 0;
                    cmp.MrW = 2;
                    cmp.MrP = this.znu.zno;
                    cmp.MrX = this.znu.videoSource > 0 ? 2 : 0;
                    cmp.MrT = this.znu.znq;
                    cmp.MrS = this.znu.djh;
                    if (this.znu.status == 103) {
                        o.bhj();
                        t.b t = t.t(t.Qx(ehx), this.znu.jsk, TXRecordCommon.AUDIO_SAMPLERATE_8000);
                        if (t.ret < 0 || t.dAc == 0) {
                            Log.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + ehx + "]  Error ");
                            this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                            i2 = -1;
                        } else {
                            Log.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + ehx + "] read ret:" + t.ret + " readlen:" + t.dAc + " newOff:" + t.jsR + " netOff:" + this.znu.jsk);
                            if (t.jsR < this.znu.jsk) {
                                Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + ehx + "] newOff:" + t.jsR + " OldtOff:" + this.znu.jsk);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                                i2 = -1;
                            } else {
                                byte[] bArr = new byte[t.dAc];
                                System.arraycopy(t.buf, 0, bArr, 0, t.dAc);
                                cmp.MrU = this.znu.jsk;
                                SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                                sKBuiltinBuffer_t.setBuffer(bArr);
                                cmp.MrV = sKBuiltinBuffer_t;
                            }
                        }
                    } else {
                        o.bhj();
                        t.b t2 = t.t(t.Qw(ehx), this.znu.znp, TXRecordCommon.AUDIO_SAMPLERATE_8000);
                        if (t2.ret < 0 || t2.dAc == 0) {
                            Log.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + ehx + "]  Error ");
                            this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                            i2 = -1;
                        } else {
                            Log.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + ehx + "] read ret:" + t2.ret + " readlen:" + t2.dAc + " newOff:" + t2.jsR + " netOff:" + this.znu.znp);
                            if (t2.jsR < this.znu.znp) {
                                Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + ehx + "] newOff:" + t2.jsR + " OldtOff:" + this.znu.znp);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                                i2 = -1;
                            } else if (t2.jsR >= com.tencent.mm.modelvideo.c.jpN) {
                                Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + ehx + "] maxsize:" + com.tencent.mm.modelvideo.c.jpN);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                                i2 = -1;
                            } else {
                                byte[] bArr2 = new byte[t2.dAc];
                                System.arraycopy(t2.buf, 0, bArr2, 0, t2.dAc);
                                cmp.MrR = this.znu.znp;
                                cmp.MrU = this.znu.jsk;
                                SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                                sKBuiltinBuffer_t2.setBuffer(bArr2);
                                cmp.MrQ = sKBuiltinBuffer_t2;
                            }
                        }
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    AppMethodBeat.o(26361);
                    return i2;
                }
            } else if (this.znu.msgType == 34) {
                cmp.MrW = 0;
                cmp.MrX = 0;
                cmp.MrQ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                cmp.MrR = 0;
                cmp.MrV = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                cmp.MrU = 0;
                cmp.MrT = 0;
                cmp.MrS = this.znu.djh;
                b Rf = com.tencent.mm.modelvoice.s.Rf(this.znu.ehx());
                if (Rf == null) {
                    this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                    Log.d("MicroMsg.NetSceneMasSend", "fileop is null");
                    z = true;
                } else {
                    com.tencent.mm.modelvoice.g dB = Rf.dB(this.znu.znp, TXRecordCommon.AUDIO_SAMPLERATE_8000);
                    if (dB.ret < 0) {
                        Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.znu.ehx() + "] read ret:" + dB.ret + " readlen:" + dB.dAc + " newOff:" + dB.jsR + " netOff:" + this.znu.znp);
                        this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                        z = true;
                    } else if (dB.jsR < this.znu.znp || dB.jsR >= 469000) {
                        Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.znu.ehx() + "] read ret:" + dB.ret + " readlen:" + dB.dAc + " newOff:" + dB.jsR + " netOff:" + this.znu.znp);
                        this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                        z = true;
                    } else if (this.znu.djh <= 0) {
                        Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.znu.ehx() + "] read totalLen:" + this.znu.djh);
                        this.retCode = com.tencent.mm.compatible.util.f.getLine() + 10000;
                        z = true;
                    } else {
                        byte[] bArr3 = new byte[dB.dAc];
                        System.arraycopy(dB.buf, 0, bArr3, 0, dB.dAc);
                        cmp.MrQ = new SKBuiltinBuffer_t().setBuffer(bArr3);
                        cmp.MrP = this.znu.zno;
                        cmp.MrR = this.znu.znp;
                        cmp.Msa = Rf.getFormat();
                    }
                }
                if (z) {
                    AppMethodBeat.o(26361);
                    return -1;
                }
            } else if (this.znu.msgType == 3) {
                if (Util.isNullOrNil(this.znu.ehx())) {
                    Log.d("MicroMsg.NetSceneMasSend", "getFilename is null");
                    this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                    z = true;
                } else {
                    cmp.MrW = 0;
                    cmp.MrX = 0;
                    cmp.MrQ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                    cmp.MrR = 0;
                    cmp.MrV = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                    cmp.MrU = 0;
                    cmp.MrT = 0;
                    cmp.MrP = 0;
                    cmp.MrT = this.znu.znq;
                    cmp.MrS = this.znu.djh;
                    cmp.LYt = this.iXp;
                    StringBuilder sb = new StringBuilder();
                    bg.aVF();
                    String sb2 = sb.append(c.aSY()).append(this.znu.ehx()).toString();
                    int i3 = this.znu.djh - this.znu.znp;
                    if (i3 > 8000) {
                        i3 = 8000;
                    }
                    byte[] aW = s.aW(sb2, this.znu.znp, i3);
                    if (Util.isNullOrNil(aW)) {
                        Log.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.znu.ehx() + "]  Error ");
                        this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                        z = true;
                    } else {
                        cmp.MrR = this.znu.znp;
                        cmp.MrU = this.znu.jsk;
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        sKBuiltinBuffer_t3.setBuffer(aW);
                        cmp.MrQ = sKBuiltinBuffer_t3;
                    }
                }
                if (z) {
                    AppMethodBeat.o(26361);
                    return -1;
                }
            } else if (this.znu.msgType == 1) {
                cmp.MrQ = new SKBuiltinBuffer_t().setBuffer(this.znu.ehx().getBytes());
                cmp.MrS = this.znu.djh;
                cmp.MrP = 0;
                cmp.MrR = 0;
                cmp.MrV = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                cmp.MrU = 0;
                cmp.MrT = 0;
                cmp.MrW = 0;
                cmp.MrX = 0;
            } else {
                Log.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.znu.msgType);
                this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                AppMethodBeat.o(26361);
                return -1;
            }
            int dispatch = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(26361);
            return dispatch;
        } else {
            Log.d("MicroMsg.NetSceneMasSend", "msg type :" + this.znu.msgType);
            this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(26361);
            return -1;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 2500;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        String str2;
        String str3;
        AppMethodBeat.i(26362);
        Log.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + i3 + " errCode:" + i4);
        updateDispatchId(i2);
        if (i3 != 0 || i4 != 0) {
            Log.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + i3 + " errCode:" + i4);
            this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(26362);
        } else if (this.znu == null) {
            Log.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
            this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(26362);
        } else if (this.znu.status == 104 || this.znu.status == 103) {
            cmq cmq = (cmq) this.rr.iLL.iLR;
            cmp cmp = (cmp) this.rr.iLK.iLR;
            if (cmp.MrT > 0 && cmp.MrV != null && cmp.MrV.getBuffer() != null && !Util.isNullOrNil(cmp.MrV.getBuffer().toByteArray()) && cmp.MrU != cmq.MrU - cmp.MrV.getILen()) {
                Log.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
                this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
                this.callback.onSceneEnd(3, -1, "doScene failed", this);
                AppMethodBeat.o(26362);
            } else if (cmp.MrS <= 0 || cmp.MrQ == null || cmp.MrQ.getBuffer() == null || Util.isNullOrNil(cmp.MrQ.getBuffer().toByteArray()) || cmp.MrR == cmq.MrR - cmp.MrQ.getILen()) {
                this.znu.jsm = Util.nowSecond();
                int i5 = this.znu.status;
                if (i5 == 103) {
                    this.znu.jsk = cmp.MrV.getILen() + cmp.MrU;
                    if (this.znu.jsk >= this.znu.znq) {
                        this.znu.status = 199;
                    }
                } else if (i5 == 104) {
                    this.znu.znp = cmp.MrQ.getILen() + cmp.MrR;
                    if (this.znu.znp >= this.znu.djh) {
                        if (this.znu.znq > 0) {
                            this.znu.status = 103;
                        } else {
                            this.znu.status = 199;
                        }
                    }
                } else {
                    Log.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:".concat(String.valueOf(i5)));
                    this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
                    this.callback.onSceneEnd(3, -1, "doScene failed", this);
                    AppMethodBeat.o(26362);
                    return;
                }
                if (this.znu.status == 199) {
                    b ehF = h.ehF();
                    a aVar = this.znu;
                    if (aVar != null) {
                        aVar.cSx = -1;
                        ContentValues contentValues = new ContentValues();
                        if ((aVar.cSx & 1) != 0) {
                            contentValues.put("clientid", aVar.ehw());
                        }
                        if ((aVar.cSx & 2) != 0) {
                            contentValues.put("status", Integer.valueOf(aVar.status));
                        }
                        if ((aVar.cSx & 4) != 0) {
                            contentValues.put("createtime", Long.valueOf(aVar.createTime));
                        }
                        if ((aVar.cSx & 8) != 0) {
                            contentValues.put("lastmodifytime", Long.valueOf(aVar.jsm));
                        }
                        if ((aVar.cSx & 16) != 0) {
                            contentValues.put("filename", aVar.ehx());
                        }
                        if ((aVar.cSx & 32) != 0) {
                            contentValues.put("thumbfilename", aVar.ehy());
                        }
                        if ((aVar.cSx & 64) != 0) {
                            contentValues.put("tolist", aVar.ehz());
                        }
                        if ((aVar.cSx & 128) != 0) {
                            contentValues.put("tolistcount", Integer.valueOf(aVar.znn));
                        }
                        if ((aVar.cSx & 256) != 0) {
                            contentValues.put("msgtype", Integer.valueOf(aVar.msgType));
                        }
                        if ((aVar.cSx & 512) != 0) {
                            contentValues.put("mediatime", Integer.valueOf(aVar.zno));
                        }
                        if ((aVar.cSx & 1024) != 0) {
                            contentValues.put("datanetoffset", Integer.valueOf(aVar.znp));
                        }
                        if ((aVar.cSx & 2048) != 0) {
                            contentValues.put("datalen", Integer.valueOf(aVar.djh));
                        }
                        if ((aVar.cSx & 4096) != 0) {
                            contentValues.put("thumbnetoffset", Integer.valueOf(aVar.jsk));
                        }
                        if ((aVar.cSx & 8192) != 0) {
                            contentValues.put("thumbtotallen", Integer.valueOf(aVar.znq));
                        }
                        if ((aVar.cSx & 16384) != 0) {
                            contentValues.put("reserved1", Integer.valueOf(aVar.videoSource));
                        }
                        if ((aVar.cSx & 32768) != 0) {
                            contentValues.put("reserved2", Integer.valueOf(aVar.znr));
                        }
                        if ((aVar.cSx & 65536) != 0) {
                            if (aVar.iFt == null) {
                                str3 = "";
                            } else {
                                str3 = aVar.iFt;
                            }
                            contentValues.put("reserved3", str3);
                        }
                        if ((aVar.cSx & 131072) != 0) {
                            if (aVar.iFu == null) {
                                str2 = "";
                            } else {
                                str2 = aVar.iFu;
                            }
                            contentValues.put("reserved4", str2);
                        }
                        if (((int) ehF.iFy.insert("massendinfo", "clientid", contentValues)) != -1) {
                            bg.aVF();
                            boolean z = c.aST().bjY("masssendapp") == null;
                            az azVar = new az();
                            azVar.setUsername("masssendapp");
                            azVar.setContent(b.a(aVar));
                            azVar.yA(aVar.createTime);
                            azVar.nv(0);
                            azVar.nt(0);
                            azVar.Co(null);
                            if (z) {
                                bg.aVF();
                                c.aST().e(azVar);
                            } else {
                                bg.aVF();
                                c.aST().a(azVar, "masssendapp");
                            }
                            ehF.doNotify();
                        }
                    }
                    Log.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:".concat(String.valueOf(this.hvh != null ? this.hvh.apr() : 0)));
                    this.callback.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(26362);
                } else if (doScene(dispatcher(), this.callback) == -1) {
                    this.retCode = 0 - (com.tencent.mm.compatible.util.f.getLine() + 10000);
                    this.callback.onSceneEnd(3, -1, "doScene failed", this);
                    AppMethodBeat.o(26362);
                } else {
                    AppMethodBeat.o(26362);
                }
            } else {
                Log.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
                this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
                this.callback.onSceneEnd(3, -1, "doScene failed", this);
                AppMethodBeat.o(26362);
            }
        } else {
            Log.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.znu.status);
            this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine()) - 10000;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(26362);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 193;
    }
}
