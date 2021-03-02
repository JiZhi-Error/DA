package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.aa;
import com.tencent.mm.al.u;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static String iND = "";
    private static long iNE = 0;

    public static void MK(String str) {
        AppMethodBeat.i(123976);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(123976);
            return;
        }
        c MT = ag.bah().MT(str);
        MT.field_attrSyncVersion = null;
        MT.field_incrementUpdateTime = 0;
        ag.bah().h(MT);
        AppMethodBeat.o(123976);
    }

    public static void ML(String str) {
        AppMethodBeat.i(123977);
        iND = str;
        iNE = System.currentTimeMillis();
        AppMethodBeat.o(123977);
    }

    public static boolean MM(String str) {
        AppMethodBeat.i(123978);
        if (!Util.isEqual(iND, str) || System.currentTimeMillis() - iNE >= 1000) {
            AppMethodBeat.o(123978);
            return false;
        }
        AppMethodBeat.o(123978);
        return true;
    }

    static boolean e(c cVar) {
        AppMethodBeat.i(123979);
        if (cVar == null) {
            Log.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
            AppMethodBeat.o(123979);
            return false;
        } else if (!aZz()) {
            AppMethodBeat.o(123979);
            return false;
        } else {
            int i2 = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("MMBizAttrSyncFreq", -1);
            if (i2 == -1) {
                Log.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
                i2 = LocalCache.TIME_HOUR;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = cVar.field_incrementUpdateTime;
            Log.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", Long.valueOf(currentTimeMillis), Long.valueOf(j2), Integer.valueOf(i2), cVar.field_attrSyncVersion);
            if (currentTimeMillis - j2 >= ((long) i2) * 1000) {
                AppMethodBeat.o(123979);
                return true;
            }
            AppMethodBeat.o(123979);
            return false;
        }
    }

    public static boolean aZz() {
        int i2;
        AppMethodBeat.i(123980);
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, (Object) null);
        if (obj == null || !(obj instanceof Integer)) {
            Log.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
            i2 = 1;
        } else {
            i2 = ((Integer) obj).intValue();
        }
        Log.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", Integer.valueOf(i2));
        if (i2 == 1) {
            AppMethodBeat.o(123980);
            return true;
        }
        AppMethodBeat.o(123980);
        return false;
    }

    public final boolean MN(final String str) {
        AppMethodBeat.i(123981);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
            AppMethodBeat.o(123981);
            return false;
        } else if (MM(str)) {
            Log.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is just delete.");
            AppMethodBeat.o(123981);
            return false;
        } else {
            Log.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
            c MT = ag.bah().MT(str);
            if (!e(MT)) {
                Log.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
                AppMethodBeat.o(123981);
                return false;
            }
            if (str.equals("gh_f0a92aa7146c")) {
                Log.i("MicroMsg.BizAttrRenovator", "username == ContactStorageLogic.SPUSER_WXPAY_COLLECTION，go NetScene Plugin");
                g.aAg().hqi.a(new aa(new aa.a<aa>() {
                    /* class com.tencent.mm.al.a.AnonymousClass2 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
                    @Override // com.tencent.mm.al.aa.a
                    public final /* synthetic */ void a(int i2, int i3, String str, aa aaVar) {
                        JSONObject jSONObject;
                        AppMethodBeat.i(212158);
                        aa aaVar2 = aaVar;
                        Log.i("MicroMsg.BizAttrRenovator", "onSceneEnd errType = " + i2 + ", errCode = " + i3 + ",errMsg = " + str);
                        if (i2 == 0 && i3 == 0) {
                            btv bab = aaVar2.bab();
                            if (bab == null) {
                                Log.e("MicroMsg.BizAttrRenovator", "resp is null.");
                                AppMethodBeat.o(212158);
                                return;
                            }
                            Log.i("MicroMsg.BizAttrRenovator", "resp : %s", bab.MaE);
                            c MT = ag.bah().MT(str);
                            try {
                                if (Util.isNullOrNil(MT.field_extInfo)) {
                                    jSONObject = new JSONObject();
                                } else {
                                    jSONObject = new JSONObject(MT.field_extInfo);
                                }
                            } catch (Exception e2) {
                                Log.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", e2);
                                jSONObject = new JSONObject();
                            }
                            try {
                                jSONObject.put("MMBizMenu", bab.MaE);
                            } catch (JSONException e3) {
                                Log.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs MMBizMenu failed：value(%s), exception : %s.", bab.MaE, e3);
                            }
                            MT.field_extInfo = jSONObject.toString();
                            ag.bah().h(MT);
                            Log.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
                            AppMethodBeat.o(212158);
                            return;
                        }
                        Log.e("MicroMsg.BizAttrRenovator", "scene.getType() = %s", Integer.valueOf(aaVar2.getType()));
                        AppMethodBeat.o(212158);
                    }
                }), 0);
            }
            final WeakReference weakReference = new WeakReference(null);
            g.aAg().hqi.a(new u(str, MT.field_attrSyncVersion, new u.a<u>() {
                /* class com.tencent.mm.al.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
                @Override // com.tencent.mm.al.u.a
                public final /* synthetic */ void a(int i2, int i3, String str, u uVar) {
                    nn nnVar;
                    String str2;
                    int size;
                    boolean z;
                    boolean z2;
                    AppMethodBeat.i(123975);
                    u uVar2 = uVar;
                    Log.i("MicroMsg.BizAttrRenovator", "onSceneEnd errType = " + i2 + ", errCode = " + i3 + ",errMsg = " + str);
                    if (a.MM(str)) {
                        Log.i("MicroMsg.BizAttrRenovator", "onNetSceneEndCallback return, username is just delete.");
                        AppMethodBeat.o(123975);
                        return;
                    }
                    if (weakReference != null) {
                        weakReference.get();
                    }
                    if (i2 == 0 && i3 == 0) {
                        if (uVar2.rr == null || uVar2.rr.iLL.iLR == null) {
                            nnVar = null;
                        } else {
                            nnVar = (nn) uVar2.rr.iLL.iLR;
                        }
                        if (nnVar == null) {
                            Log.e("MicroMsg.BizAttrRenovator", "resp is null.");
                            AppMethodBeat.o(123975);
                            return;
                        }
                        Object[] objArr = new Object[3];
                        objArr[0] = str;
                        if (nnVar.KSW == null) {
                            str2 = null;
                        } else {
                            str2 = new String(nnVar.KSW.zy);
                        }
                        objArr[1] = str2;
                        if (nnVar.KSX == null) {
                            size = 0;
                        } else {
                            size = nnVar.KSX.size();
                        }
                        objArr[2] = Integer.valueOf(size);
                        Log.i("MicroMsg.BizAttrRenovator", "[BizAttr] biz(%s) Attribute LastAttrVersion = %s, UpdateInfoList.size = %s", objArr);
                        if (nnVar.KSX == null) {
                            Log.e("MicroMsg.BizAttrRenovator", "[BizAttr] resp.UpdateInfoList null");
                            AppMethodBeat.o(123975);
                            return;
                        }
                        String str3 = str;
                        LinkedList<no> linkedList = nnVar.KSX;
                        if (Util.isNullOrNil(str3)) {
                            Log.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, username is null.");
                            z = false;
                        } else {
                            c MT = ag.bah().MT(str3);
                            if (!a.e(MT)) {
                                Log.i("MicroMsg.BizAttrRenovator", "Do not need to update bizAttrs now.(username : %s)", str3);
                                z = false;
                            } else {
                                as Kn = ((l) g.af(l.class)).aSN().Kn(str3);
                                if (Kn == null || ((int) Kn.gMZ) == 0 || !Kn.gBM()) {
                                    Log.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact do not exist.(username : %s)", str3);
                                    z = false;
                                } else {
                                    if (Util.isNullOrNil(Kn.field_username)) {
                                        Kn.setUsername(str3);
                                    }
                                    z = a.a(Kn, MT, linkedList);
                                }
                            }
                        }
                        if (!z) {
                            Log.i("MicroMsg.BizAttrRenovator", "notifyDataSetChanged, after updateBizAttributes.");
                            AppMethodBeat.o(123975);
                            return;
                        }
                        if (nnVar.KSW != null) {
                            String str4 = str;
                            String encodeHexString = Util.encodeHexString(nnVar.KSW.zy);
                            if (Util.isNullOrNil(str4) || Util.isNullOrNil(encodeHexString)) {
                                z2 = false;
                            } else {
                                z2 = ag.bah().execSQL("BizInfo", String.format("update %s set %s='%s', %s=%d where %s='%s'", "BizInfo", "attrSyncVersion", encodeHexString, "incrementUpdateTime", Long.valueOf(System.currentTimeMillis()), ch.COL_USERNAME, str4));
                            }
                            Log.i("MicroMsg.BizAttrRenovator", "Update attrSyncVersion of bizInfo succ = %b.", Boolean.valueOf(z2));
                        }
                        AppMethodBeat.o(123975);
                        return;
                    }
                    Log.e("MicroMsg.BizAttrRenovator", "scene.getType() = %s", Integer.valueOf(uVar2.getType()));
                    AppMethodBeat.o(123975);
                }
            }), 0);
            AppMethodBeat.o(123981);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.tencent.mm.storage.as r19, com.tencent.mm.api.c r20, java.util.List<com.tencent.mm.protocal.protobuf.no> r21) {
        /*
        // Method dump skipped, instructions count: 739
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.al.a.a(com.tencent.mm.storage.as, com.tencent.mm.api.c, java.util.List):boolean");
    }

    private static boolean a(JSONObject jSONObject, String str, String str2, String str3) {
        AppMethodBeat.i(212159);
        try {
            if ("IsShowHeadImgInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if ("IsHideInputToolbarInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if (!"IsAgreeProtocol".equals(str)) {
                if ("InteractiveMode".equals(str)) {
                    jSONObject.put(str, Util.getInt(str2, jSONObject.optInt(str)));
                } else if ("CanReceiveSpeexVoice".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConnectorMsgType".equals(str)) {
                    jSONObject.put(str, Util.getInt(str2, jSONObject.optInt(str)));
                } else if ("ReportLocationType".equals(str)) {
                    jSONObject.put(str, Util.getInt(str2, jSONObject.optInt(str)));
                } else if ("AudioPlayType".equals(str)) {
                    jSONObject.put(str, Util.getInt(str2, jSONObject.optInt(str)));
                } else if ("IsShowMember".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConferenceContactExpireTime".equals(str)) {
                    jSONObject.put(str, str2);
                } else if (!"VerifyMsg2Remark".equals(str)) {
                    if ("VerifyContactPromptTitle".equals(str)) {
                        jSONObject.put(str, str2);
                    } else if (!"IsSubscribeStat".equals(str)) {
                        if ("ScanQRCodeType".equals(str)) {
                            jSONObject.put(str, Util.getInt(str2, jSONObject.optInt(str)));
                        } else if ("ServiceType".equals(str)) {
                            jSONObject.put(str, Util.getInt(str2, jSONObject.optInt(str)));
                        } else if (!"NeedShowUserAddrObtaining".equals(str)) {
                            if ("SupportEmoticonLinkPrefix".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("FunctionFlag".equals(str)) {
                                jSONObject.put(str, Util.getInt(str2, jSONObject.optInt(str)));
                            } else if ("NotifyManage".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("ServicePhone".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("IsTrademarkProtection".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if (!"CanReceiveLongVideo".equals(str)) {
                                if ("TrademarkUrl".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("TrademarkName".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("MMBizMenu".equals(str)) {
                                    if (str3.equals("gh_f0a92aa7146c")) {
                                        Log.i("MicroMsg.BizAttrRenovator", "username.equals(ContactStorageLogic.SPUSER_WXPAY_COLLECTION),dont update MMBizMenu.");
                                        AppMethodBeat.o(212159);
                                        return true;
                                    }
                                    jSONObject.put(str, str2);
                                } else if ("VerifySource".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("PersonVerifyInfo".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if (!"MMBizTabbar".equals(str)) {
                                    if ("PayShowInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("HardwareBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("EnterpriseBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if (!"MainPage".equals(str)) {
                                        if ("RegisterSource".equals(str)) {
                                            jSONObject.put(str, str2);
                                        } else if (!"IBeaconBizInfo".equals(str)) {
                                            if ("WxaAppInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WxaAppVersionInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WXAppType".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("BindWxaInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("AcctTransferInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else {
                                                AppMethodBeat.o(212159);
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", str, str2, e2);
        }
        AppMethodBeat.o(212159);
        return true;
    }
}
