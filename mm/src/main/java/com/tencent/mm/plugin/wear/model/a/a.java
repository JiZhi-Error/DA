package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.plugin.wear.model.a.b;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public final class a implements b {
    private GoogleApiClient Iyl = new GoogleApiClient.Builder(MMApplicationContext.getContext()).addApi(Wearable.API).build();

    public a() {
        AppMethodBeat.i(30038);
        AppMethodBeat.o(30038);
    }

    @Override // com.tencent.mm.plugin.wear.model.a.b
    public final boolean isAvailable() {
        AppMethodBeat.i(30039);
        if (h.avk() || h.avj()) {
            AppMethodBeat.o(30039);
            return true;
        }
        AppMethodBeat.o(30039);
        return false;
    }

    @Override // com.tencent.mm.plugin.wear.model.a.b
    public final void fVZ() {
        AppMethodBeat.i(30040);
        this.Iyl.disconnect();
        fWa();
        AppMethodBeat.o(30040);
    }

    @Override // com.tencent.mm.plugin.wear.model.a.b
    public final GoogleApiClient fWa() {
        AppMethodBeat.i(30041);
        if (!this.Iyl.isConnected()) {
            Log.i("MicroMsg.Wear.GlobalConnection", "connect to google api client");
            ConnectionResult blockingConnect = this.Iyl.blockingConnect(30, TimeUnit.SECONDS);
            if (!blockingConnect.isSuccess()) {
                Log.e("MicroMsg.Wear.GlobalConnection", "google api client connect error, code=%d, ", Integer.valueOf(blockingConnect.getErrorCode()));
            }
        }
        GoogleApiClient googleApiClient = this.Iyl;
        AppMethodBeat.o(30041);
        return googleApiClient;
    }

    @Override // com.tencent.mm.plugin.wear.model.a.b
    public final byte[] a(Asset asset) {
        AppMethodBeat.i(30042);
        DataApi.GetFdForAssetResult await = Wearable.DataApi.getFdForAsset(fWa(), asset).await();
        Status status = await.getStatus();
        if (!status.isSuccess()) {
            Log.e("MicroMsg.Wear.GlobalConnection", "read asset data not success errorCode=%d | errorMsg=%s", Integer.valueOf(status.getStatusCode()), status.getStatusMessage());
            AppMethodBeat.o(30042);
            return null;
        }
        byte[] readFromStream = e.readFromStream(await.getInputStream());
        AppMethodBeat.o(30042);
        return readFromStream;
    }

    @Override // com.tencent.mm.plugin.wear.model.a.b
    public final b.a w(String str, byte[] bArr) {
        b.a aVar;
        AppMethodBeat.i(30043);
        HashSet<String> fWb = fWb();
        b.a aVar2 = new b.a();
        Iterator<String> it = fWb.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = aVar2;
                break;
            }
            String next = it.next();
            if (!fWa().isConnected()) {
                aVar = new b.a((byte) 0);
            } else {
                b.a aVar3 = new b.a();
                Status status = Wearable.MessageApi.sendMessage(fWa(), next, str, bArr).await(2, TimeUnit.SECONDS).getStatus();
                if (!status.isSuccess()) {
                    aVar3.code = 131072;
                    aVar3.errMsg = status.getStatusMessage();
                    Log.e("MicroMsg.Wear.GlobalConnection", "send message not success errorCode=%d | errorMsg=%s", Integer.valueOf(status.getStatusCode()), status.getStatusMessage());
                }
                Object[] objArr = new Object[3];
                objArr[0] = next;
                objArr[1] = str;
                objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                Log.d("MicroMsg.Wear.GlobalConnection", "send Message %s %s %d", objArr);
                aVar = aVar3;
            }
            if (aVar.code != 0) {
                break;
            }
        }
        AppMethodBeat.o(30043);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.wear.model.a.b
    public final HashSet<String> fWb() {
        AppMethodBeat.i(30044);
        HashSet<String> hashSet = new HashSet<>();
        NodeApi.GetConnectedNodesResult await = Wearable.NodeApi.getConnectedNodes(fWa()).await();
        if (await != null) {
            for (Node node : await.getNodes()) {
                hashSet.add(node.getId());
            }
        }
        AppMethodBeat.o(30044);
        return hashSet;
    }

    @Override // com.tencent.mm.plugin.wear.model.a.b
    public final b.a x(String str, byte[] bArr) {
        AppMethodBeat.i(30045);
        if (!fWa().isConnected()) {
            b.a aVar = new b.a((byte) 0);
            AppMethodBeat.o(30045);
            return aVar;
        }
        PutDataMapRequest create = PutDataMapRequest.create(str);
        create.getDataMap().putLong("key_timestamp", System.currentTimeMillis());
        create.getDataMap().putAsset("key_data", Asset.createFromBytes(bArr));
        PutDataRequest asPutDataRequest = create.asPutDataRequest();
        Wearable.DataApi.putDataItem(fWa(), asPutDataRequest);
        Log.d("MicroMsg.Wear.GlobalConnection", "send data request path=%s | length=%d", asPutDataRequest.getUri().getPath(), Integer.valueOf(asPutDataRequest.getData().length));
        b.a aVar2 = new b.a();
        AppMethodBeat.o(30045);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.wear.model.a.b
    public final boolean u(Uri uri) {
        AppMethodBeat.i(30046);
        Wearable.DataApi.deleteDataItems(fWa(), uri);
        Log.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", uri);
        AppMethodBeat.o(30046);
        return true;
    }

    @Override // com.tencent.mm.plugin.wear.model.a.b
    public final boolean fWc() {
        AppMethodBeat.i(30047);
        if (!fWa().isConnected()) {
            AppMethodBeat.o(30047);
            return false;
        } else if (fWb().size() == 0) {
            AppMethodBeat.o(30047);
            return false;
        } else {
            AppMethodBeat.o(30047);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.wear.model.a.b
    public final void finish() {
        AppMethodBeat.i(30048);
        this.Iyl.disconnect();
        AppMethodBeat.o(30048);
    }

    @Override // com.tencent.mm.plugin.wear.model.a.b
    public final void fWd() {
        AppMethodBeat.i(30049);
        DataItemBuffer await = Wearable.DataApi.getDataItems(fWa()).await();
        Iterator it = await.iterator();
        while (it.hasNext()) {
            DataItem dataItem = (DataItem) it.next();
            String uri = dataItem.getUri().toString();
            if (uri.startsWith("/wechat")) {
                Log.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", uri);
                Wearable.DataApi.deleteDataItems(fWa(), dataItem.getUri());
            }
        }
        await.release();
        AppMethodBeat.o(30049);
    }
}
