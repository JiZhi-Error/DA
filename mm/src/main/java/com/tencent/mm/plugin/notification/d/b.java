package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static final String AHd = (com.tencent.mm.loader.j.b.aKJ() + "FailMsgFileCache");

    static {
        AppMethodBeat.i(26753);
        AppMethodBeat.o(26753);
    }

    public static void init() {
        AppMethodBeat.i(26749);
        Log.d("MicroMsg.FailMsgFileCache", "init FailMsgFileCache");
        new o(AHd).mkdirs();
        AppMethodBeat.o(26749);
    }

    public static void a(int i2, a aVar) {
        AppMethodBeat.i(26750);
        String str = null;
        if (i2 == 1) {
            str = AHd + "/normalMsg";
        } else if (i2 == 2) {
            str = AHd + "/snsMsg";
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FailMsgFileCache", "flushToDisk error, cannot find filename");
            AppMethodBeat.o(26750);
            return;
        }
        Log.d("MicroMsg.FailMsgFileCache", "flushToDisk, filename:%s", str);
        String eyU = aVar.eyU();
        Log.d("MicroMsg.FailMsgFileCache", "flushToDisk, cacheContent:%s", eyU);
        if (Util.isNullOrNil(eyU)) {
            Log.d("MicroMsg.FailMsgFileCache", "flushToDisk, content is empty");
            AppMethodBeat.o(26750);
            return;
        }
        s.f(str, eyU.getBytes(), eyU.length());
        AppMethodBeat.o(26750);
    }

    public static a TS(int i2) {
        String str;
        AppMethodBeat.i(26751);
        if (i2 == 1) {
            str = AHd + "/normalMsg";
        } else if (i2 == 2) {
            str = AHd + "/snsMsg";
        } else {
            str = null;
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FailMsgFileCache", "extractFromDisk error, cannot find filename");
            AppMethodBeat.o(26751);
            return null;
        }
        Log.d("MicroMsg.FailMsgFileCache", "extractFromDisk, filename:%s", str);
        try {
            String boY = s.boY(str);
            Log.d("MicroMsg.FailMsgFileCache", "extractFromDisk, cacheContent:%s", boY);
            a aVar = new a();
            aVar.aIZ(boY);
            AppMethodBeat.o(26751);
            return aVar;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.FailMsgFileCache", e2, "", new Object[0]);
            Log.d("MicroMsg.FailMsgFileCache", "extractFromDisk error:%s", e2.toString());
            AppMethodBeat.o(26751);
            return null;
        }
    }

    public static void TT(int i2) {
        AppMethodBeat.i(26752);
        String str = null;
        if (i2 == 1) {
            str = AHd + "/normalMsg";
        } else if (i2 == 2) {
            str = AHd + "/snsMsg";
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FailMsgFileCache", "removeFile error, cannot find filename");
            AppMethodBeat.o(26752);
            return;
        }
        Log.d("MicroMsg.FailMsgFileCache", "removeFile, filename:%s", str);
        if (s.YS(str)) {
            new o(str).delete();
        }
        AppMethodBeat.o(26752);
    }

    public static class a {
        public com.tencent.mm.plugin.notification.c.b AHe = new com.tencent.mm.plugin.notification.c.b();
        public int AHf;
        public ArrayList<Long> AHg = new ArrayList<>();
        public ArrayList<Long> AHh = new ArrayList<>();

        public a() {
            AppMethodBeat.i(26745);
            AppMethodBeat.o(26745);
        }

        public a(com.tencent.mm.plugin.notification.c.b bVar, int i2, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
            AppMethodBeat.i(26746);
            this.AHe = bVar;
            this.AHf = i2;
            this.AHg = arrayList;
            this.AHh = arrayList2;
            AppMethodBeat.o(26746);
        }

        public final String eyU() {
            AppMethodBeat.i(26747);
            Log.d("MicroMsg.FailMsgFileCache", "CacheObj, serializeToString");
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.AHe.AHb.size(); i2++) {
                    jSONArray.put(this.AHe.get(i2));
                }
                Log.d("MicroMsg.FailMsgFileCache", "serializeToString, msgArray.size:%d", Integer.valueOf(jSONArray.length()));
                jSONObject.put("msg_list", jSONArray);
                Log.d("MicroMsg.FailMsgFileCache", "serializeToString, currentSendIndex:%d", Integer.valueOf(this.AHf));
                jSONObject.put("current_send_index", this.AHf);
                JSONArray jSONArray2 = new JSONArray();
                Iterator<Long> it = this.AHg.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                Log.d("MicroMsg.FailMsgFileCache", "serializeToString, successArray.size:%d", Integer.valueOf(jSONArray2.length()));
                jSONObject.put("success_msg_list", jSONArray2);
                JSONArray jSONArray3 = new JSONArray();
                Iterator<Long> it2 = this.AHh.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                Log.d("MicroMsg.FailMsgFileCache", "serializeToString, failArray.size:%d", Integer.valueOf(jSONArray3.length()));
                jSONObject.put("fail_msg_list", jSONArray3);
                String jSONObject2 = jSONObject.toString();
                AppMethodBeat.o(26747);
                return jSONObject2;
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.FailMsgFileCache", e2, "", new Object[0]);
                AppMethodBeat.o(26747);
                return null;
            }
        }

        public final void aIZ(String str) {
            AppMethodBeat.i(26748);
            Log.d("MicroMsg.FailMsgFileCache", "CacheObj, createFromFileContent");
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.FailMsgFileCache", "[createFromFileContent] content is null! stack:%s", Util.getStack());
                AppMethodBeat.o(26748);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("msg_list");
                JSONArray jSONArray2 = jSONObject.getJSONArray("fail_msg_list");
                JSONArray jSONArray3 = jSONObject.getJSONArray("success_msg_list");
                int i2 = jSONObject.getInt("current_send_index");
                Log.d("MicroMsg.FailMsgFileCache", "createFromFileContent, msgArray.size:%d, failArray.size:%d, successArray.size:%d, index:%d", Integer.valueOf(jSONArray.length()), Integer.valueOf(jSONArray2.length()), Integer.valueOf(jSONArray3.length()), Integer.valueOf(i2));
                this.AHe.clear();
                this.AHh.clear();
                this.AHg.clear();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    this.AHe.HC(jSONArray.getLong(i3));
                }
                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                    this.AHh.add(Long.valueOf(jSONArray2.getLong(i4)));
                }
                for (int i5 = 0; i5 < jSONArray3.length(); i5++) {
                    this.AHg.add(Long.valueOf(jSONArray3.getLong(i5)));
                }
                this.AHf = i2;
                AppMethodBeat.o(26748);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FailMsgFileCache", e2, str, new Object[0]);
                AppMethodBeat.o(26748);
            }
        }
    }
}
