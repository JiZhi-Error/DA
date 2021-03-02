package com.tencent.mm.network;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class z implements CronetLogic.CronetTaskCallback, y {
    private String csu = "GET";
    private boolean jEX = false;
    private String jEY = "";
    private Map<String, String> jEZ = new HashMap();
    public int jFa = 5000;
    public int jFb = 5000;
    private int jFc;
    String jFd;
    private byte[] jFe;
    private boolean jFf = false;
    public boolean jFg = false;
    private boolean jFh = false;
    private boolean jFi = false;
    private CronetLogic.CronetTaskCallback jFj;
    private int jFk = 8;
    private int jFl = -1;
    private byte[] jFm;
    private String jFn = "";
    private String jFo = "";
    private Map<String, List<String>> jFp = new HashMap();
    public int jFq = 0;
    public boolean jFr = false;
    private int mErrorCode = 0;
    private String mSavePath;
    private String mURL;

    public z(String str, int i2) {
        AppMethodBeat.i(132870);
        this.mURL = str;
        this.jFc = i2;
        AppMethodBeat.o(132870);
    }

    @Override // com.tencent.mm.network.y
    public final void setRequestMethod(String str) {
        this.csu = str;
    }

    @Override // com.tencent.mm.network.y
    public final void setRequestProperty(String str, String str2) {
        AppMethodBeat.i(132871);
        this.jEZ.put(str, str2);
        AppMethodBeat.o(132871);
    }

    @Override // com.tencent.mm.network.y
    public final void setConnectTimeout(int i2) {
        this.jFa = i2;
    }

    @Override // com.tencent.mm.network.y
    public final void setReadTimeout(int i2) {
        this.jFb = i2;
    }

    public final void bjR() {
        this.jFf = false;
    }

    @Override // com.tencent.mm.network.y
    public final void setUseCaches(boolean z) {
        this.jFg = z;
    }

    public final void setSavePath(String str) {
        this.mSavePath = str;
    }

    public final String getSavePath() {
        return this.mSavePath;
    }

    public final void bjS() {
        this.jFk = 2;
    }

    public final void a(CronetLogic.CronetTaskCallback cronetTaskCallback) {
        this.jFj = cronetTaskCallback;
    }

    public final void bjT() {
        this.jFh = true;
    }

    @Override // com.tencent.mm.network.y
    public final void RU(String str) {
        AppMethodBeat.i(132872);
        this.jEZ.put("Referer", str);
        AppMethodBeat.o(132872);
    }

    public final void bjU() {
        this.jFq = 1500;
    }

    public final void connect() {
        AppMethodBeat.i(197109);
        if ("".equals(this.jEY) && this.jFk == 2) {
            bjV();
        }
        AppMethodBeat.o(197109);
    }

    @Override // com.tencent.mm.network.y
    public final void disconnect() {
    }

    @Override // com.tencent.mm.network.y
    public final String getContentType() {
        AppMethodBeat.i(259569);
        String headerField = getHeaderField("content-type");
        AppMethodBeat.o(259569);
        return headerField;
    }

    @Override // com.tencent.mm.network.y
    public final int getHeaderFieldInt(String str, int i2) {
        AppMethodBeat.i(132874);
        try {
            i2 = Integer.parseInt(getHeaderField(str));
            AppMethodBeat.o(132874);
        } catch (Exception e2) {
            Log.e("MicroMsg.CronetConnect", "getHeaderFieldInt field " + str + " " + e2.getLocalizedMessage());
            AppMethodBeat.o(132874);
        }
        return i2;
    }

    @Override // com.tencent.mm.network.y
    public final int getContentLength() {
        AppMethodBeat.i(132875);
        String headerField = getHeaderField("content-length");
        if (headerField == null) {
            AppMethodBeat.o(132875);
            return -1;
        }
        long j2 = -1;
        try {
            j2 = Long.parseLong(headerField);
        } catch (Exception e2) {
            Log.e("MicroMsg.CronetConnect", "getContentLength content-length " + e2.getLocalizedMessage());
        }
        if (j2 > 2147483647L) {
            AppMethodBeat.o(132875);
            return -1;
        }
        int i2 = (int) j2;
        AppMethodBeat.o(132875);
        return i2;
    }

    @Override // com.tencent.mm.network.y
    public final String getHost() {
        return "";
    }

    @Override // com.tencent.mm.network.y
    public final int getResponseCode() {
        AppMethodBeat.i(132876);
        if (!this.jEX || this.jFl == -1) {
            if ("".equals(this.jEY)) {
                bjV();
            }
            int i2 = this.jFl;
            AppMethodBeat.o(132876);
            return i2;
        }
        int i3 = this.jFl;
        AppMethodBeat.o(132876);
        return i3;
    }

    @Override // com.tencent.mm.network.y
    public final InputStream getInputStream() {
        AppMethodBeat.i(132877);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.jFm);
        AppMethodBeat.o(132877);
        return byteArrayInputStream;
    }

    public final String getResponseMessage() {
        return this.jFo;
    }

    @Override // com.tencent.mm.network.y
    public final String getHeaderField(String str) {
        AppMethodBeat.i(132878);
        if (str.isEmpty()) {
            AppMethodBeat.o(132878);
            return "";
        }
        List<String> list = this.jFp.get(str.toLowerCase());
        if (list == null) {
            Log.w("MicroMsg.CronetConnect", "getHeaderField %s is null", str);
            AppMethodBeat.o(132878);
            return "";
        }
        Log.i("MicroMsg.CronetConnect", "getHeaderField field %s, value %s ", str, list.get(0));
        String str2 = list.get(0);
        AppMethodBeat.o(132878);
        return str2;
    }

    @Override // com.tencent.mm.network.y
    public final Map<String, List<String>> getHeaderFields() {
        return this.jFp;
    }

    public final String getURL() {
        return this.mURL;
    }

    @Override // com.tencent.mm.network.y
    public final String bjP() {
        return this.jFd;
    }

    @Override // com.tencent.mm.network.y
    public final int bjQ() {
        return this.jFc;
    }

    @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
    public final void onDownloadProgressChanged(String str, CronetLogic.CronetDownloadProgress cronetDownloadProgress) {
        AppMethodBeat.i(197111);
        if (this.jFj != null) {
            this.jFj.onDownloadProgressChanged(str, cronetDownloadProgress);
        }
        AppMethodBeat.o(197111);
    }

    @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
    public final void onCronetTaskCompleted(String str, CronetLogic.CronetTaskResult cronetTaskResult) {
        AppMethodBeat.i(132879);
        Log.i("MicroMsg.CronetConnect", "receive callback, status %d, error %d, msg %s", Integer.valueOf(cronetTaskResult.statusCode), Integer.valueOf(cronetTaskResult.errorCode), cronetTaskResult.errorMsg);
        a(cronetTaskResult);
        if (this.jFj != null) {
            this.jFj.onCronetTaskCompleted(str, cronetTaskResult);
        }
        AppMethodBeat.o(132879);
    }

    @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
    public final int onCronetReceiveHeader(CronetLogic.ResponseHeader responseHeader, int i2) {
        AppMethodBeat.i(197112);
        if (this.jFj != null) {
            this.jFp = CronetLogic.getHeaderList(responseHeader);
            int onCronetReceiveHeader = this.jFj.onCronetReceiveHeader(responseHeader, i2);
            AppMethodBeat.o(197112);
            return onCronetReceiveHeader;
        }
        AppMethodBeat.o(197112);
        return 0;
    }

    private synchronized void a(CronetLogic.CronetTaskResult cronetTaskResult) {
        AppMethodBeat.i(132880);
        this.jEX = true;
        this.jFl = cronetTaskResult.statusCode;
        this.jFm = cronetTaskResult.data;
        this.jFn = cronetTaskResult.errorMsg;
        this.mErrorCode = cronetTaskResult.errorCode;
        this.jFo = cronetTaskResult.statusText;
        this.jFp = cronetTaskResult.getHeaderMapList();
        notify();
        AppMethodBeat.o(132880);
    }

    private synchronized void bjV() {
        CronetLogic.CronetHttpsCreateResult startCronetDownloadTask;
        AppMethodBeat.i(132881);
        CronetLogic.CronetRequestParams cronetRequestParams = new CronetLogic.CronetRequestParams();
        cronetRequestParams.url = this.mURL;
        cronetRequestParams.followRedirect = false;
        cronetRequestParams.bodyData = this.jFe;
        cronetRequestParams.method = this.csu;
        cronetRequestParams.useMemoryCache = this.jFg;
        cronetRequestParams.useHttp2 = this.jFh;
        cronetRequestParams.useQuic = this.jFi;
        cronetRequestParams.makeRequestHeader(this.jEZ);
        cronetRequestParams.taskType = this.jFk;
        if (this.jFq != 0) {
            cronetRequestParams.defaultHttpTaskParams = new CronetLogic.DefaultHttpTaskParams();
            cronetRequestParams.defaultHttpTaskParams.reportId = this.jFq;
        }
        switch (this.jFk) {
            case 1:
                startCronetDownloadTask = CronetLogic.startCronetHttpTask(cronetRequestParams, this);
                break;
            case 2:
                cronetRequestParams.savePath = this.mSavePath;
                cronetRequestParams.needWirteCache = true;
                startCronetDownloadTask = CronetLogic.startCronetDownloadTask(cronetRequestParams, this);
                break;
            default:
                cronetRequestParams.useNewdns = this.jFr;
                startCronetDownloadTask = CronetLogic.startCronetDefaultHttpTask(cronetRequestParams, this);
                break;
        }
        this.jEY = startCronetDownloadTask.taskId;
        try {
            wait((long) (this.jFa + this.jFb));
        } catch (Exception e2) {
            Log.e("MicroMsg.CronetConnect", "createAndStartCronetRequest " + e2.getLocalizedMessage());
        }
        if (!this.jEX) {
            CronetLogic.cancelCronetTask(this.jEY);
        }
        bjW();
        AppMethodBeat.o(132881);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, java.util.List<java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    private void bjW() {
        AppMethodBeat.i(132882);
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.jFp);
        this.jFp.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!(entry == null || entry.getKey() == null)) {
                this.jFp.put(((String) entry.getKey()).toLowerCase(), entry.getValue());
            }
        }
        AppMethodBeat.o(132882);
    }
}
