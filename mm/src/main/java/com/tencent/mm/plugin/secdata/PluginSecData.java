package com.tencent.mm.plugin.secdata;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J-\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\n\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0018JF\u0010\u0019\u001a\u00020\r\"\n\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u001dH\u0016J=\u0010\u001e\u001a\u0004\u0018\u0001H\u0013\"\n\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001fJF\u0010 \u001a\u00020\r\"\n\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u001dH\u0016J=\u0010!\u001a\u0004\u0018\u0001H\u0013\"\n\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\u0012\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\rH\u0016J\u001a\u0010)\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016J6\u0010*\u001a\u00020\r\"\n\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u001dH\u0016J\u001a\u0010+\u001a\u00020,2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016J3\u0010-\u001a\u00020\r\"\n\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u0002H\u0013H\u0016¢\u0006\u0002\u0010/JC\u00100\u001a\u00020\r\"\n\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u0002H\u00132\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u001dH\u0016¢\u0006\u0002\u00101J3\u00102\u001a\u00020,\"\n\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u0002H\u0013H\u0016¢\u0006\u0002\u00103R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/secdata/PluginSecData;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/secdata/IPluginSecData;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "()V", "TAG", "", "secDataDB", "Lcom/tencent/mm/plugin/secdata/model/SecDataDB;", "secReportDataInfoStorage", "Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfoStorage;", "configure", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getOnlyMemory", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "subType", "", "id", "(ILjava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getWithClear", "clazz", "Ljava/lang/Class;", "callback", "Lcom/tencent/mm/plugin/secdata/ISecReportDataCallback;", "getWithClearSync", "(ILjava/lang/String;Ljava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getWithoutClear", "getWithoutClearSync", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parallelsDependency", "removeFromMemory", "removeFromStorage", "removeFromStorageSync", "", "updateOnlyMemory", "value", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "updateWithSave", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;Lcom/tencent/mm/plugin/secdata/ISecReportDataCallback;)V", "updateWithSaveSync", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)Z", "plugin-sec-data_release"})
public final class PluginSecData extends com.tencent.mm.kernel.b.f implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, g {
    private com.tencent.mm.plugin.secdata.a.a CVZ;
    private com.tencent.mm.plugin.secdata.a.d CWa;
    private final String TAG = "MicroMsg.SecData.PluginSecData";

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void installed() {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public final String name() {
        return "PluginSecData";
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void dependency() {
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        com.tencent.mm.storagebase.h hVar;
        Boolean bool;
        AppMethodBeat.i(219157);
        com.tencent.mm.plugin.secdata.a.a aVar = this.CVZ;
        if (aVar != null) {
            String str = aVar.TAG;
            Object[] objArr = new Object[2];
            objArr[0] = aVar.iFy;
            com.tencent.mm.storagebase.h hVar2 = aVar.iFy;
            objArr[1] = hVar2 != null ? Boolean.valueOf(hVar2.isOpen()) : null;
            Log.w(str, "close db:%s isOpen:%b ", objArr);
            if (!(aVar.iFy == null || (hVar = aVar.iFy) == null || !hVar.isOpen())) {
                String str2 = aVar.TAG;
                Object[] objArr2 = new Object[1];
                com.tencent.mm.storagebase.h hVar3 = aVar.iFy;
                if (hVar3 != null) {
                    bool = Boolean.valueOf(hVar3.inTransaction());
                } else {
                    bool = null;
                }
                objArr2[0] = bool;
                Log.w(str2, "close in trans :%b ", objArr2);
                com.tencent.mm.storagebase.h hVar4 = aVar.iFy;
                if (hVar4 != null) {
                    hVar4.close();
                }
                aVar.iFy = null;
            }
        }
        this.CWa = null;
        com.tencent.mm.plugin.secdata.a.c cVar = com.tencent.mm.plugin.secdata.a.c.CWk;
        com.tencent.mm.plugin.secdata.a.c.clear();
        AppMethodBeat.o(219157);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(219158);
        try {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(ar.a.USERINFO_SEC_DATA_DB_VERSION_INT, (Object) 0);
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            String sb2 = sb.append(aAh2.azM()).append("secdata/").toString();
            if (!p.j(obj, 2)) {
                Log.i(this.TAG, "diff version, delete old db;");
                s.deleteDir(sb2);
            }
            if (!s.YS(sb2)) {
                s.boN(sb2);
            }
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_SEC_DATA_DB_VERSION_INT, (Object) 2);
            com.tencent.mm.plugin.secdata.a.a aVar = new com.tencent.mm.plugin.secdata.a.a(sb2 + "SecData.db");
            com.tencent.mm.storagebase.h hVar = aVar.iFy;
            if (hVar != null) {
                com.tencent.mm.plugin.secdata.a.d dVar = new com.tencent.mm.plugin.secdata.a.d(hVar);
                com.tencent.mm.ac.d.c("SecDBTag", new e(dVar));
                this.CWa = dVar;
            }
            this.CVZ = aVar;
            AppMethodBeat.o(219158);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "create sec data db", new Object[0]);
            AppMethodBeat.o(219158);
        }
    }

    @Override // com.tencent.mm.plugin.secdata.g
    public final <T extends com.tencent.mm.bw.a> T getOnlyMemory(int i2, String str) {
        AppMethodBeat.i(219159);
        if (str != null) {
            com.tencent.mm.plugin.secdata.a.c cVar = com.tencent.mm.plugin.secdata.a.c.CWk;
            T t = (T) com.tencent.mm.plugin.secdata.a.c.eSp().get(i2 + '_' + str);
            AppMethodBeat.o(219159);
            return t;
        }
        AppMethodBeat.o(219159);
        return null;
    }

    @Override // com.tencent.mm.plugin.secdata.g
    public final <T extends com.tencent.mm.bw.a> void updateOnlyMemory(int i2, String str, T t) {
        AppMethodBeat.i(219160);
        if (str != null) {
            String str2 = i2 + '_' + str;
            com.tencent.mm.plugin.secdata.a.c cVar = com.tencent.mm.plugin.secdata.a.c.CWk;
            HashMap<String, com.tencent.mm.bw.a> eSp = com.tencent.mm.plugin.secdata.a.c.eSp();
            if (t == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protobuf.BaseProtoBuf");
                AppMethodBeat.o(219160);
                throw tVar;
            }
            eSp.put(str2, t);
            AppMethodBeat.o(219160);
            return;
        }
        AppMethodBeat.o(219160);
    }

    public final void removeFromMemory(int i2, String str) {
        AppMethodBeat.i(219161);
        if (str != null) {
            com.tencent.mm.plugin.secdata.a.c cVar = com.tencent.mm.plugin.secdata.a.c.CWk;
            com.tencent.mm.plugin.secdata.a.c.eSp().remove(i2 + '_' + str);
            AppMethodBeat.o(219161);
            return;
        }
        AppMethodBeat.o(219161);
    }

    @Override // com.tencent.mm.plugin.secdata.g
    public final <T extends com.tencent.mm.bw.a> void getWithClear(int i2, String str, Class<T> cls, i<T> iVar) {
        AppMethodBeat.i(219162);
        if (str != null) {
            com.tencent.mm.ac.d.c("SecDBTag", new a(str, this, i2, cls, iVar));
            AppMethodBeat.o(219162);
            return;
        }
        com.tencent.mm.ac.d.c("SecDBTag", new b(iVar));
        AppMethodBeat.o(219162);
    }

    @Override // com.tencent.mm.plugin.secdata.g
    public final <T extends com.tencent.mm.bw.a> void getWithoutClear(int i2, String str, Class<T> cls, i<T> iVar) {
        AppMethodBeat.i(219163);
        Log.i(this.TAG, "getWithoutClear subType:" + i2 + " id:" + str);
        if (str != null) {
            com.tencent.mm.ac.d.c("SecDBTag", new c(str, this, i2, cls, iVar));
            AppMethodBeat.o(219163);
            return;
        }
        com.tencent.mm.ac.d.c("SecDBTag", new d(iVar));
        AppMethodBeat.o(219163);
    }

    @Override // com.tencent.mm.plugin.secdata.g
    public final <T extends com.tencent.mm.bw.a> void updateWithSave(int i2, String str, T t, i<T> iVar) {
        AppMethodBeat.i(219164);
        if (str != null) {
            com.tencent.mm.ac.d.c("SecDBTag", new h(str, this, i2, str, t, iVar));
            AppMethodBeat.o(219164);
            return;
        }
        com.tencent.mm.ac.d.c("SecDBTag", new i(iVar, t));
        AppMethodBeat.o(219164);
    }

    public final <T extends com.tencent.mm.bw.a> boolean updateWithSaveSync(int i2, String str, T t) {
        com.tencent.mm.plugin.secdata.a.b aMZ;
        AppMethodBeat.i(219165);
        if (str != null) {
            String str2 = i2 + '_' + str;
            com.tencent.mm.plugin.secdata.a.d dVar = this.CWa;
            if (dVar == null || (aMZ = dVar.aMZ(str2)) == null) {
                PluginSecData pluginSecData = this;
                com.tencent.mm.plugin.secdata.a.b bVar = new com.tencent.mm.plugin.secdata.a.b();
                bVar.field_id = str2;
                bVar.field_originId = str;
                bVar.field_createTime = cl.aWA();
                bVar.field_updateTime = bVar.field_createTime;
                bVar.field_expireTime = bVar.field_updateTime + 259200000;
                bVar.field_type = i2;
                bVar.field_data = t != null ? t.toByteArray() : null;
                com.tencent.mm.plugin.secdata.a.d dVar2 = pluginSecData.CWa;
                if ((dVar2 != null ? dVar2.a(bVar) : -1) >= 0) {
                    AppMethodBeat.o(219165);
                    return true;
                }
                AppMethodBeat.o(219165);
                return false;
            }
            aMZ.field_originId = str;
            aMZ.field_type = i2;
            aMZ.field_data = t != null ? t.toByteArray() : null;
            aMZ.field_updateTime = cl.aWA();
            aMZ.field_expireTime = aMZ.field_updateTime + 259200000;
            com.tencent.mm.plugin.secdata.a.d dVar3 = this.CWa;
            if ((dVar3 != null ? dVar3.b(aMZ) : 0) > 0) {
                AppMethodBeat.o(219165);
                return true;
            }
            AppMethodBeat.o(219165);
            return false;
        }
        AppMethodBeat.o(219165);
        return false;
    }

    public final <T extends com.tencent.mm.bw.a> T getWithClearSync(int i2, String str, Class<T> cls) {
        com.tencent.mm.plugin.secdata.a.b aMZ;
        T t = null;
        AppMethodBeat.i(219166);
        if (str != null) {
            String str2 = i2 + '_' + str;
            com.tencent.mm.plugin.secdata.a.d dVar = this.CWa;
            if (dVar == null || (aMZ = dVar.aMZ(str2)) == null) {
                AppMethodBeat.o(219166);
            } else {
                if (cls != null) {
                    t = cls.newInstance();
                }
                if (t != null) {
                    try {
                        t.parseFrom(aMZ.field_data);
                    } catch (Exception e2) {
                    }
                }
                com.tencent.mm.plugin.secdata.a.d dVar2 = this.CWa;
                if (dVar2 != null) {
                    dVar2.aNa(str);
                }
                AppMethodBeat.o(219166);
            }
        } else {
            AppMethodBeat.o(219166);
        }
        return t;
    }

    @Override // com.tencent.mm.plugin.secdata.g
    public final <T extends com.tencent.mm.bw.a> T getWithoutClearSync(int i2, String str, Class<T> cls) {
        com.tencent.mm.plugin.secdata.a.b aMZ;
        T t = null;
        AppMethodBeat.i(219167);
        if (str != null) {
            String str2 = i2 + '_' + str;
            com.tencent.mm.plugin.secdata.a.d dVar = this.CWa;
            if (dVar == null || (aMZ = dVar.aMZ(str2)) == null) {
                AppMethodBeat.o(219167);
            } else {
                if (cls != null) {
                    t = cls.newInstance();
                }
                if (t != null) {
                    try {
                        t.parseFrom(aMZ.field_data);
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(219167);
            }
        } else {
            AppMethodBeat.o(219167);
        }
        return t;
    }

    @Override // com.tencent.mm.plugin.secdata.g
    public final boolean removeFromStorageSync(int i2, String str) {
        int i3;
        AppMethodBeat.i(219168);
        if (str != null) {
            String str2 = i2 + '_' + str;
            com.tencent.mm.plugin.secdata.a.d dVar = this.CWa;
            if (dVar != null) {
                i3 = dVar.aNa(str2);
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                AppMethodBeat.o(219168);
                return true;
            }
            AppMethodBeat.o(219168);
            return false;
        }
        AppMethodBeat.o(219168);
        return false;
    }

    public final <T extends com.tencent.mm.bw.a> void removeFromStorage(int i2, String str, i<T> iVar) {
        AppMethodBeat.i(219169);
        if (str != null) {
            com.tencent.mm.ac.d.c("SecDBTag", new f(str, this, i2, iVar));
            AppMethodBeat.o(219169);
            return;
        }
        com.tencent.mm.ac.d.c("SecDBTag", new g(iVar));
        AppMethodBeat.o(219169);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public final void parallelsDependency() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.secdata.a.d CWg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(com.tencent.mm.plugin.secdata.a.d dVar) {
            super(0);
            this.CWg = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(219152);
            long aWA = cl.aWA();
            com.tencent.mm.plugin.secdata.a.d dVar = this.CWg;
            Log.i(dVar.TAG, "cleanExpireData result:".concat(String.valueOf(dVar.iFy.delete("SecReportDataInfo", "expireTime < ?", new String[]{String.valueOf(cl.aWA())}))));
            Log.i(this.CWg.TAG, "cleanExpireData cost:" + (cl.aWA() - aWA));
            x xVar = x.SXb;
            AppMethodBeat.o(219152);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithClear$1$1"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String CWb;
        final /* synthetic */ PluginSecData CWc;
        final /* synthetic */ int CWd;
        final /* synthetic */ Class CWe;
        final /* synthetic */ i CWf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, PluginSecData pluginSecData, int i2, Class cls, i iVar) {
            super(0);
            this.CWb = str;
            this.CWc = pluginSecData;
            this.CWd = i2;
            this.CWe = cls;
            this.CWf = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
            if (r0 == null) goto L_0x005b;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 113
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.secdata.PluginSecData.a.invoke():java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithClear$2$1"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ i CWf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(i iVar) {
            super(0);
            this.CWf = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(219149);
            i iVar = this.CWf;
            if (iVar != null) {
                iVar.a(3, false, null);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(219149);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithoutClear$1$1"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String CWb;
        final /* synthetic */ PluginSecData CWc;
        final /* synthetic */ int CWd;
        final /* synthetic */ Class CWe;
        final /* synthetic */ i CWf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, PluginSecData pluginSecData, int i2, Class cls, i iVar) {
            super(0);
            this.CWb = str;
            this.CWc = pluginSecData;
            this.CWd = i2;
            this.CWe = cls;
            this.CWf = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
            if (r0 == null) goto L_0x004e;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
                r6 = this;
                r5 = 219150(0x3580e, float:3.07095E-40)
                r4 = 3
                r1 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                int r2 = r6.CWd
                java.lang.StringBuilder r0 = r0.append(r2)
                r2 = 95
                java.lang.StringBuilder r0 = r0.append(r2)
                java.lang.String r2 = r6.CWb
                java.lang.StringBuilder r0 = r0.append(r2)
                java.lang.String r0 = r0.toString()
                com.tencent.mm.plugin.secdata.PluginSecData r2 = r6.CWc
                com.tencent.mm.plugin.secdata.a.d r2 = com.tencent.mm.plugin.secdata.PluginSecData.access$getSecReportDataInfoStorage$p(r2)
                if (r2 == 0) goto L_0x004e
                com.tencent.mm.plugin.secdata.a.b r2 = r2.aMZ(r0)
                if (r2 == 0) goto L_0x004e
                java.lang.Class r0 = r6.CWe
                if (r0 == 0) goto L_0x005e
                java.lang.Object r0 = r0.newInstance()
                com.tencent.mm.bw.a r0 = (com.tencent.mm.bw.a) r0
            L_0x003b:
                if (r0 == 0) goto L_0x0042
                byte[] r2 = r2.field_data     // Catch:{ Exception -> 0x0062 }
                r0.parseFrom(r2)     // Catch:{ Exception -> 0x0062 }
            L_0x0042:
                com.tencent.mm.plugin.secdata.i r2 = r6.CWf
                if (r2 == 0) goto L_0x0060
                r3 = 1
                r2.a(r4, r3, r0)
                kotlin.x r0 = kotlin.x.SXb
            L_0x004c:
                if (r0 != 0) goto L_0x0058
            L_0x004e:
                com.tencent.mm.plugin.secdata.i r0 = r6.CWf
                if (r0 == 0) goto L_0x0058
                r2 = 0
                r0.a(r4, r2, r1)
                kotlin.x r0 = kotlin.x.SXb
            L_0x0058:
                kotlin.x r0 = kotlin.x.SXb
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                return r0
            L_0x005e:
                r0 = r1
                goto L_0x003b
            L_0x0060:
                r0 = r1
                goto L_0x004c
            L_0x0062:
                r2 = move-exception
                goto L_0x0042
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.secdata.PluginSecData.c.invoke():java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithoutClear$2$1"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ i CWf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(i iVar) {
            super(0);
            this.CWf = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(219151);
            i iVar = this.CWf;
            if (iVar != null) {
                iVar.a(0, false, null);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(219151);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$updateWithSave$1$1"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String CWb;
        final /* synthetic */ PluginSecData CWc;
        final /* synthetic */ int CWd;
        final /* synthetic */ i CWf;
        final /* synthetic */ com.tencent.mm.bw.a CWh;
        final /* synthetic */ String pAg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(String str, PluginSecData pluginSecData, int i2, String str2, com.tencent.mm.bw.a aVar, i iVar) {
            super(0);
            this.CWb = str;
            this.CWc = pluginSecData;
            this.CWd = i2;
            this.pAg = str2;
            this.CWh = aVar;
            this.CWf = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0070, code lost:
            if (r0 == null) goto L_0x0072;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 228
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.secdata.PluginSecData.h.invoke():java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$updateWithSave$2$1"})
    static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ i CWf;
        final /* synthetic */ com.tencent.mm.bw.a CWh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(i iVar, com.tencent.mm.bw.a aVar) {
            super(0);
            this.CWf = iVar;
            this.CWh = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(219156);
            i iVar = this.CWf;
            if (iVar != null) {
                iVar.a(0, false, this.CWh);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(219156);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$removeFromStorage$1$1"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String CWb;
        final /* synthetic */ PluginSecData CWc;
        final /* synthetic */ int CWd;
        final /* synthetic */ i CWf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, PluginSecData pluginSecData, int i2, i iVar) {
            super(0);
            this.CWb = str;
            this.CWc = pluginSecData;
            this.CWd = i2;
            this.CWf = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z = false;
            AppMethodBeat.i(219153);
            String str = this.CWd + '_' + this.CWb;
            com.tencent.mm.plugin.secdata.a.d dVar = this.CWc.CWa;
            int aNa = dVar != null ? dVar.aNa(str) : 0;
            i iVar = this.CWf;
            if (iVar != null) {
                if (aNa > 0) {
                    z = true;
                }
                iVar.a(4, z, null);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(219153);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$removeFromStorage$2$1"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ i CWf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(i iVar) {
            super(0);
            this.CWf = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(219154);
            i iVar = this.CWf;
            if (iVar != null) {
                iVar.a(0, false, null);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(219154);
            return xVar;
        }
    }
}
