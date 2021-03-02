package com.tencent.mm.bb;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.s;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n extends q implements s, m {
    private i callback;
    private int flags;
    private boolean jhp;
    private int packageType;
    private d rr;

    public n(boolean z) {
        AppMethodBeat.i(150813);
        this.jhp = false;
        this.flags = -1;
        this.packageType = 26;
        this.jhp = false;
        Log.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
        Log.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", Boolean.valueOf(z));
        if (z) {
            this.flags = 1;
        }
        AppMethodBeat.o(150813);
    }

    public n(int i2) {
        AppMethodBeat.i(150814);
        this.jhp = false;
        this.flags = -1;
        this.packageType = i2;
        this.jhp = false;
        Log.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:".concat(String.valueOf(i2)));
        AppMethodBeat.o(150814);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150815);
        this.callback = iVar;
        Log.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.packageType);
        d.a aVar = new d.a();
        aVar.iLN = new bsa();
        aVar.iLO = new bsb();
        aVar.uri = "/cgi-bin/micromsg-bin/getpackagelist";
        aVar.funcId = JsApiGetBackgroundAudioState.CTRL_INDEX;
        aVar.iLP = 51;
        aVar.respCmdId = 1000000051;
        this.rr = aVar.aXF();
        bsa bsa = (bsa) this.rr.iLK.iLR;
        LinkedList<cyb> linkedList = new LinkedList<>();
        if (!com.tencent.mm.kernel.g.aAf().azp()) {
            AppMethodBeat.o(150815);
            return -1;
        }
        q[] tJ = v.bev().tJ(this.packageType);
        if (tJ != null && tJ.length > 0) {
            for (int i2 = 0; i2 < tJ.length; i2++) {
                cyb cyb = new cyb();
                cyb.xNF = tJ[i2].id;
                if (ac.jOs && this.packageType == 7) {
                    Log.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
                    cyb.Version = 0;
                } else if (12 != this.packageType || com.tencent.mm.vfs.s.YS(com.tencent.mm.kernel.g.aAh().cachePath + "address")) {
                    cyb.Version = tJ[i2].version;
                } else {
                    Log.i("MicroMsg.NetSceneGetPackageList", "MMRCPTADDRESS final save file not found, set pkg.Version=0");
                    cyb.Version = 0;
                }
                Log.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", Integer.valueOf(cyb.xNF), Integer.valueOf(cyb.Version));
                linkedList.add(cyb);
            }
        }
        bsa.oTA = linkedList;
        bsa.oTz = linkedList.size();
        bsa.oUv = this.packageType;
        if (this.flags != -1) {
            bsa.KHa = this.flags;
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150815);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 20;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
    }

    @Override // com.tencent.mm.ak.q
    public final boolean uniqueInNetsceneQueue() {
        return true;
    }

    private q a(cyb cyb) {
        AppMethodBeat.i(150816);
        q qVar = new q();
        qVar.id = cyb.xNF;
        qVar.version = cyb.Version;
        qVar.name = cyb.Name;
        qVar.size = cyb.oUq;
        qVar.jhw = cyb.PackName;
        qVar.status = 5;
        qVar.dMe = this.packageType;
        AppMethodBeat.o(150816);
        return qVar;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(150817);
        Log.i("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.packageType), str);
        if (i3 == 0 || i4 == 0) {
            bsb bsb = (bsb) ((d) sVar).iLL.iLR;
            if (bsb.oUv != this.packageType) {
                Log.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", Integer.valueOf(bsb.oUv));
                this.callback.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(150817);
                return;
            }
            LinkedList<cyb> linkedList = bsb.oTA;
            Log.i("MicroMsg.NetSceneGetPackageList", "summer list size:" + (linkedList == null ? 0 : linkedList.size()) + " packageType: " + this.packageType + " resp.Type: " + bsb.oUv);
            if (this.packageType == 2) {
                i(linkedList);
            } else if (this.packageType == 1) {
                h(linkedList);
            } else if (this.packageType == 4) {
                j(linkedList);
            } else if (this.packageType == 6) {
                Log.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
            } else if (this.packageType == 7) {
                k(linkedList);
            } else if (this.packageType == 9) {
                g(linkedList);
            } else if (this.packageType == 10) {
                if (linkedList == null || linkedList.size() <= 0) {
                    Log.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
                } else {
                    Log.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
                    cyb cyb = linkedList.get(0);
                    q dt = v.bev().dt(cyb.xNF, this.packageType);
                    q a2 = a(cyb);
                    a2.cSx = -1;
                    if (dt == null) {
                        v.bev().a(a2);
                    } else {
                        v.bev().b(a2);
                    }
                }
            } else if (this.packageType != 11) {
                if (this.packageType == 12) {
                    m(linkedList);
                } else if (this.packageType == 5) {
                    n(linkedList);
                } else if (this.packageType == 20) {
                    l(linkedList);
                } else if (this.packageType == 17) {
                    if (linkedList == null || linkedList.size() == 0) {
                        Log.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
                    } else {
                        cyb cyb2 = linkedList.get(0);
                        Log.d("MicroMsg.NetSceneGetPackageList", cyb2.Name + " - " + cyb2.xNF + " - " + cyb2.PackName + " - " + cyb2.oUq);
                        q dt2 = v.bev().dt(cyb2.xNF, this.packageType);
                        q a3 = a(cyb2);
                        a3.cSx = -1;
                        if (dt2 == null) {
                            v.bev().a(a3);
                        } else {
                            v.bev().b(a3);
                        }
                        pq pqVar = new pq();
                        try {
                            pqVar.dVG.content = z.a(cyb2.KIA);
                            if (pqVar.dVG.content != null) {
                                EventCenter.instance.asyncPublish(pqVar, Looper.getMainLooper());
                            }
                        } catch (Exception e2) {
                            Log.e("MicroMsg.NetSceneGetPackageList", e2.getMessage());
                        }
                    }
                } else if (this.packageType != 18) {
                    if (this.packageType == 19) {
                        aA(linkedList);
                    } else if (this.packageType == 21) {
                        if (linkedList == null || linkedList.size() <= 0) {
                            Log.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                        } else {
                            cyb cyb3 = linkedList.get(0);
                            Log.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + cyb3 + "|id = " + cyb3.xNF + "|Name = " + cyb3.Name + "|PackName = " + cyb3.PackName + "|Size = " + cyb3.oUq + "|Version = " + cyb3.Version);
                            q dt3 = v.bev().dt(cyb3.xNF, this.packageType);
                            q a4 = a(cyb3);
                            a4.cSx = -1;
                            if (dt3 == null) {
                                v.bev().a(a4);
                            } else if (dt3.version < a4.version) {
                                v.bev().b(a4);
                            } else {
                                Log.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", Integer.valueOf(dt3.version), Integer.valueOf(a4.version));
                            }
                        }
                    } else if (23 == this.packageType) {
                        if (linkedList == null || linkedList.size() <= 0) {
                            Log.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                        } else {
                            cyb cyb4 = linkedList.get(0);
                            Log.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + cyb4 + "|id = " + cyb4.xNF + "|Name = " + cyb4.Name + "|PackName = " + cyb4.PackName + "|Size = " + cyb4.oUq + "|Version = " + cyb4.Version);
                            q dt4 = v.bev().dt(cyb4.xNF, this.packageType);
                            q a5 = a(cyb4);
                            a5.cSx = -1;
                            if (dt4 == null) {
                                v.bev().a(a5);
                            } else if (dt4.version < a5.version) {
                                v.bev().b(a5);
                            }
                        }
                    } else if (this.packageType == 26) {
                        aB(linkedList);
                    } else if (this.packageType == 36) {
                        aC(linkedList);
                    } else if (this.packageType == 37) {
                        o(linkedList);
                    }
                }
            }
            yq yqVar = new yq();
            yqVar.eeU.eeV = linkedList;
            yqVar.eeU.packageType = this.packageType;
            EventCenter.instance.publish(yqVar);
            if (bsb.KZh <= 0) {
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(150817);
            } else if (doScene(dispatcher(), this.callback) == -1) {
                this.callback.onSceneEnd(3, -1, "doScene failed", this);
                AppMethodBeat.o(150817);
            } else {
                AppMethodBeat.o(150817);
            }
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(150817);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final boolean acceptConcurrent(q qVar) {
        if ((qVar instanceof n) && this.packageType == ((n) qVar).packageType) {
            return false;
        }
        return true;
    }

    private void g(LinkedList<cyb> linkedList) {
        AppMethodBeat.i(150818);
        if (linkedList == null || linkedList.size() <= 0) {
            Log.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
            AppMethodBeat.o(150818);
            return;
        }
        v.bev();
        String bes = r.bes();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            cyb cyb = linkedList.get(i2);
            q dt = v.bev().dt(cyb.xNF, this.packageType);
            if (dt == null || dt.version != cyb.Version) {
                com.tencent.mm.vfs.s.deleteFile(bes + v.bev().dv(cyb.xNF, this.packageType));
                q a2 = a(cyb);
                a2.cSx = -1;
                if (dt == null) {
                    v.bev().a(a2);
                } else {
                    v.bev().b(a2);
                }
                com.tencent.mm.kernel.g.aAg().hqi.a(new m(a2.id, 9), 0);
            }
            if (z.a(cyb.KIA) != null) {
                Log.v("MicroMsg.NetSceneGetPackageList", "xml:".concat(String.valueOf(new String(z.a(cyb.KIA)))));
            }
            if (z.a(cyb.MDa) != null) {
                Log.v("MicroMsg.NetSceneGetPackageList", "xml2:".concat(String.valueOf(new String(z.a(cyb.MDa)))));
            }
            Log.v("MicroMsg.NetSceneGetPackageList", "xml3:" + cyb.toString());
            Log.v("MicroMsg.NetSceneGetPackageList", "xml4:" + cyb.Name);
            Log.v("MicroMsg.NetSceneGetPackageList", "xml5:" + cyb.PackName);
        }
        AppMethodBeat.o(150818);
    }

    private void h(LinkedList<cyb> linkedList) {
        boolean b2;
        AppMethodBeat.i(150819);
        if (linkedList == null || linkedList.size() <= 0) {
            Log.e("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
            AppMethodBeat.o(150819);
            return;
        }
        v.bev();
        String bes = r.bes();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            cyb cyb = linkedList.get(i2);
            q dt = v.bev().dt(cyb.xNF, this.packageType);
            if (dt == null || dt.version != cyb.Version) {
                com.tencent.mm.vfs.s.deleteFile(bes + v.bev().dv(cyb.xNF, this.packageType));
                q a2 = a(cyb);
                a2.cSx = -1;
                if (dt == null) {
                    b2 = v.bev().a(a2);
                } else {
                    b2 = v.bev().b(a2);
                }
                Log.i("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] ret:%s newInfo:%s", Boolean.valueOf(b2), a2);
            }
            byte[] a3 = z.a(cyb.KIA);
            if (a3 != null && a3.length > 0) {
                v.bev();
                String du = r.du(cyb.xNF, this.packageType);
                com.tencent.mm.vfs.s.deleteFile(bes + du);
                if (com.tencent.mm.vfs.s.e(bes + du, a3, a3.length) < 0) {
                    Log.e("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] appendBuf thumb error!");
                }
            }
        }
        AppMethodBeat.o(150819);
    }

    @Deprecated
    private void i(LinkedList<cyb> linkedList) {
        AppMethodBeat.i(150820);
        if (linkedList == null || linkedList.size() <= 0) {
            Log.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            AppMethodBeat.o(150820);
            return;
        }
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            cyb cyb = linkedList.get(i2);
            q dt = v.bev().dt(cyb.xNF, this.packageType);
            q a2 = a(cyb);
            a2.cSx = -1;
            if (dt == null) {
                v.bev().a(a2);
            } else {
                v.bev().b(a2);
            }
            byte[] a3 = z.a(cyb.KIA);
            if (a3 != null && a3.length > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new String(a3));
                arrayList.size();
            }
        }
        AppMethodBeat.o(150820);
    }

    private void j(LinkedList<cyb> linkedList) {
        AppMethodBeat.i(150821);
        if (linkedList == null || linkedList.size() <= 0) {
            Log.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            AppMethodBeat.o(150821);
            return;
        }
        Log.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        v.bev();
        String bes = r.bes();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            cyb cyb = linkedList.get(i2);
            q dt = v.bev().dt(cyb.xNF, this.packageType);
            byte[] a2 = z.a(cyb.KIA);
            if (cyb.KIA == null) {
                Log.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
            } else {
                if (dt == null || dt.version != cyb.Version) {
                    String str = new String(a2);
                    String str2 = LocaleUtil.CHINA;
                    if (str.indexOf(str2) < 0) {
                        str2 = LocaleUtil.ENGLISH;
                        if (str.indexOf(str2) < 0) {
                            str2 = LocaleUtil.TAIWAN;
                            if (str.indexOf(str2) < 0) {
                                str2 = LocaleUtil.ENGLISH;
                            }
                        }
                    }
                    String str3 = str2 + "_ARTIST.mm";
                    com.tencent.mm.vfs.s.deleteFile(bes + str3);
                    com.tencent.mm.vfs.s.deleteFile(bes + str2 + "_ARTISTF.mm");
                    com.tencent.mm.vfs.s.e(bes + str3, a2, a2.length);
                }
                q a3 = a(cyb);
                a3.cSx = -1;
                if (dt == null) {
                    v.bev().a(a3);
                } else {
                    v.bev().b(a3);
                }
                Log.d("MicroMsg.NetSceneGetPackageList", cyb.Name + " - " + cyb.xNF + " - " + cyb.PackName + " - " + cyb.oUq);
            }
        }
        AppMethodBeat.o(150821);
    }

    private void k(LinkedList<cyb> linkedList) {
        AppMethodBeat.i(150822);
        if (linkedList == null || linkedList.size() <= 0) {
            Log.d("MicroMsg.NetSceneGetPackageList", "empty config list");
            AppMethodBeat.o(150822);
            return;
        }
        Log.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + linkedList.size());
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            cyb cyb = linkedList.get(i2);
            q dt = v.bev().dt(cyb.xNF, this.packageType);
            q a2 = a(cyb);
            a2.cSx = -1;
            if (dt == null) {
                v.bev().a(a2);
            } else {
                v.bev().b(a2);
            }
            Log.d("MicroMsg.NetSceneGetPackageList", cyb.Name + " - " + cyb.xNF + " - " + cyb.PackName + " - " + cyb.oUq);
            byte[] a3 = z.a(cyb.KIA);
            Log.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : ".concat(String.valueOf(new String(a3))));
            com.tencent.mm.n.d aqK = ((a) com.tencent.mm.kernel.g.af(a.class)).aqK();
            int i3 = cyb.xNF;
            o oVar = new o(com.tencent.mm.n.d.gMf);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            try {
                o oVar2 = new o(com.tencent.mm.n.d.oH(i3));
                if (!oVar2.exists()) {
                    oVar2.createNewFile();
                }
                com.tencent.mm.vfs.s.f(com.tencent.mm.n.d.oH(i3), a3, a3.length);
                aqK.y(i3, new String(a3));
            } catch (Exception e2) {
                Log.e("MicroMsg.ConfigListDecoder", "exception:%s", Util.stackTraceToString(e2));
            }
        }
        AppMethodBeat.o(150822);
    }

    private void l(LinkedList<cyb> linkedList) {
        AppMethodBeat.i(150823);
        if (linkedList == null || linkedList.size() <= 0) {
            Log.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
            AppMethodBeat.o(150823);
            return;
        }
        Log.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        Iterator<cyb> it = linkedList.iterator();
        while (it.hasNext()) {
            cyb next = it.next();
            q dt = v.bev().dt(next.xNF, this.packageType);
            q a2 = a(next);
            a2.cSx = -1;
            if (dt == null) {
                v.bev().a(a2);
            } else {
                v.bev().b(a2);
            }
            Log.d("MicroMsg.NetSceneGetPackageList", next.Name + " - " + next.xNF + " - " + next.PackName + " - " + next.oUq);
        }
        AppMethodBeat.o(150823);
    }

    private void m(LinkedList<cyb> linkedList) {
        AppMethodBeat.i(150824);
        if (linkedList == null || linkedList.size() <= 0) {
            Log.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
            AppMethodBeat.o(150824);
            return;
        }
        Log.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + linkedList.size());
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            cyb cyb = linkedList.get(i2);
            q dt = v.bev().dt(cyb.xNF, this.packageType);
            q a2 = a(cyb);
            a2.cSx = -1;
            if (dt == null) {
                v.bev().a(a2);
            } else {
                v.bev().b(a2);
            }
            com.tencent.mm.kernel.g.aAg().hqi.a(new m(a2.id, 12), 0);
        }
        AppMethodBeat.o(150824);
    }

    private void aA(List<cyb> list) {
        AppMethodBeat.i(150825);
        if (list == null || list.size() <= 0) {
            Log.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
            AppMethodBeat.o(150825);
            return;
        }
        v.bev();
        String bes = r.bes();
        for (int i2 = 0; i2 < list.size(); i2++) {
            cyb cyb = list.get(i2);
            q dt = v.bev().dt(cyb.xNF, this.packageType);
            if (dt == null || dt.version != cyb.Version) {
                com.tencent.mm.vfs.s.deleteFile(bes + v.bev().dv(cyb.xNF, this.packageType));
                q a2 = a(cyb);
                a2.cSx = -1;
                if (dt == null) {
                    v.bev().a(a2);
                } else {
                    v.bev().b(a2);
                }
                com.tencent.mm.kernel.g.aAg().hqi.a(new m(a2.id, 19), 0);
            }
            Log.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", cyb.Name, cyb.PackName);
        }
        AppMethodBeat.o(150825);
    }

    private void aB(List<cyb> list) {
        AppMethodBeat.i(150826);
        if (list == null || list.size() == 0) {
            Log.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
            AppMethodBeat.o(150826);
            return;
        }
        Log.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", Integer.valueOf(list.size()));
        int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, (Object) -1)).intValue();
        Log.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", Integer.valueOf(intValue));
        if (intValue == -1) {
            AppMethodBeat.o(150826);
            return;
        }
        q dt = v.bev().dt(intValue, this.packageType);
        for (cyb cyb : list) {
            q a2 = a(cyb);
            Log.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", Integer.valueOf(a2.id), Integer.valueOf(a2.version));
            if (dt != null && a2.id == intValue) {
                Log.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
                v.bev().b(a2);
                AppMethodBeat.o(150826);
                return;
            } else if (dt == null && a2.id == intValue) {
                Log.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
                v.bev().a(a2);
                AppMethodBeat.o(150826);
                return;
            }
        }
        AppMethodBeat.o(150826);
    }

    private void aC(List<cyb> list) {
        AppMethodBeat.i(150827);
        if (list == null || list.size() == 0) {
            Log.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
            AppMethodBeat.o(150827);
            return;
        }
        Log.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + list.size());
        for (cyb cyb : list) {
            q dt = v.bev().dt(cyb.xNF, this.packageType);
            if (dt == null || dt.version != cyb.Version) {
                q a2 = a(cyb);
                a2.cSx = -1;
                if (dt == null) {
                    v.bev().a(a2);
                } else {
                    v.bev().b(a2);
                }
                com.tencent.mm.kernel.g.aAg().hqi.a(new m(a2.id, 36), 0);
            }
        }
        AppMethodBeat.o(150827);
    }

    private void n(LinkedList<cyb> linkedList) {
        AppMethodBeat.i(150828);
        Log.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
        if (linkedList == null || linkedList.size() == 0) {
            Log.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
            AppMethodBeat.o(150828);
            return;
        }
        Iterator<cyb> it = linkedList.iterator();
        while (it.hasNext()) {
            cyb next = it.next();
            Log.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", next.toString());
            q dt = v.bev().dt(next.xNF, this.packageType);
            q a2 = a(next);
            a2.cSx = -1;
            if (dt == null) {
                v.bev().a(a2);
            } else {
                v.bev().b(a2);
            }
        }
        AppMethodBeat.o(150828);
    }

    private void o(LinkedList<cyb> linkedList) {
        AppMethodBeat.i(150829);
        Log.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
        if (linkedList == null || linkedList.size() == 0) {
            Log.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
            AppMethodBeat.o(150829);
            return;
        }
        Log.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + linkedList.size());
        Iterator<cyb> it = linkedList.iterator();
        while (it.hasNext()) {
            cyb next = it.next();
            q dt = v.bev().dt(next.xNF, this.packageType);
            if (dt == null || dt.version != next.Version) {
                q a2 = a(next);
                a2.cSx = -1;
                if (dt == null) {
                    v.bev().a(a2);
                } else {
                    v.bev().b(a2);
                }
                com.tencent.mm.kernel.g.aAg().hqi.a(new m(a2.id, 37), 0);
            }
        }
        AppMethodBeat.o(150829);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return JsApiGetBackgroundAudioState.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.s
    public final int aYR() {
        return this.packageType;
    }
}
