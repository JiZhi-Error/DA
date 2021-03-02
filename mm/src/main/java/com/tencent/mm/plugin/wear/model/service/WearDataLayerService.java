package com.tencent.mm.plugin.wear.model.service;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.WearableListenerService;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.wear.a.b;
import com.tencent.mm.plugin.wear.model.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@JgClassChecked(author = 100, fComment = "checked", lastDate = "20141125", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class WearDataLayerService extends WearableListenerService {
    @Override // com.google.android.gms.wearable.WearableListenerService
    public void onCreate() {
        AppMethodBeat.i(30113);
        super.onCreate();
        Log.i("MicroMsg.Wear.WearDataLayerService", "onCreate");
        AppMethodBeat.o(30113);
    }

    @Override // com.google.android.gms.wearable.WearableListenerService
    public void onDestroy() {
        AppMethodBeat.i(30114);
        Log.i("MicroMsg.Wear.WearDataLayerService", "onDestroy");
        super.onDestroy();
        AppMethodBeat.o(30114);
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.DataApi.DataListener
    public void onDataChanged(DataEventBuffer dataEventBuffer) {
        AppMethodBeat.i(30115);
        Log.i("MicroMsg.Wear.WearDataLayerService", "onDataChanged %d %s", Integer.valueOf(dataEventBuffer.getCount()), dataEventBuffer.getStatus());
        Iterator it = dataEventBuffer.iterator();
        while (it.hasNext()) {
            DataEvent dataEvent = (DataEvent) it.next();
            if (dataEvent.getType() == 1) {
                Uri uri = dataEvent.getDataItem().getUri();
                if (!b.aWr(uri.getPath())) {
                    continue;
                } else {
                    Asset asset = DataMapItem.fromDataItem(dataEvent.getDataItem()).getDataMap().getAsset("key_data");
                    if (asset != null) {
                        byte[] a2 = new a().a(asset);
                        if (a2 == null) {
                            AppMethodBeat.o(30115);
                            return;
                        }
                        try {
                            Log.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", Integer.valueOf(a2.length));
                            com.tencent.mm.plugin.wear.model.b.a.aK(cy(a2));
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e2, "decode data error", new Object[0]);
                        }
                    }
                    new a().u(uri);
                }
            }
        }
        dataEventBuffer.close();
        AppMethodBeat.o(30115);
    }

    private static Bundle cy(byte[] bArr) {
        AppMethodBeat.i(30116);
        Bundle bundle = new Bundle();
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        int readInt = dataInputStream.readInt();
        bundle.putInt("key_connecttype", readInt);
        int readInt2 = dataInputStream.readInt();
        bundle.putInt("key_sessionid", readInt2);
        int readInt3 = dataInputStream.readInt();
        bundle.putInt("key_funid", readInt3);
        int readInt4 = dataInputStream.readInt();
        if (readInt4 > 0 && readInt4 < bArr.length) {
            byte[] bArr2 = new byte[readInt4];
            dataInputStream.readFully(bArr2);
            bundle.putByteArray("key_data", bArr2);
        } else if (readInt4 >= bArr.length) {
            IOException iOException = new IOException("contentLength too large ".concat(String.valueOf(readInt4)));
            AppMethodBeat.o(30116);
            throw iOException;
        }
        Log.i("MicroMsg.Wear.WearDataLayerService", "receive data connectType=%d sessionId=%d funId=%d contentLength=%d", Integer.valueOf(readInt), Integer.valueOf(readInt2), Integer.valueOf(readInt3), Integer.valueOf(readInt4));
        AppMethodBeat.o(30116);
        return bundle;
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.MessageApi.MessageListener
    public void onMessageReceived(MessageEvent messageEvent) {
        AppMethodBeat.i(30117);
        Log.i("MicroMsg.Wear.WearDataLayerService", "onMessageReceived %s", messageEvent.getPath());
        if (b.aWr(messageEvent.getPath())) {
            try {
                byte[] data = messageEvent.getData();
                Log.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", Integer.valueOf(data.length));
                com.tencent.mm.plugin.wear.model.b.a.aK(cy(data));
                AppMethodBeat.o(30117);
                return;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e2, "decode message error", new Object[0]);
            }
        }
        AppMethodBeat.o(30117);
    }

    @Override // com.google.android.gms.wearable.WearableListenerService
    public void onPeerConnected(Node node) {
        AppMethodBeat.i(30118);
        Log.i("MicroMsg.Wear.WearDataLayerService", "onPeerConnected %s", node.getId());
        Bundle bundle = new Bundle();
        bundle.putInt("key_connecttype", 3);
        bundle.putInt("key_funid", 1);
        bundle.putByteArray("key_data", node.getId().getBytes());
        com.tencent.mm.plugin.wear.model.b.a.aK(bundle);
        AppMethodBeat.o(30118);
    }

    @Override // com.google.android.gms.wearable.WearableListenerService
    public void onPeerDisconnected(Node node) {
        AppMethodBeat.i(30119);
        Log.i("MicroMsg.Wear.WearDataLayerService", "onPeerDisconnected %s", node.getId());
        Bundle bundle = new Bundle();
        bundle.putInt("key_connecttype", 3);
        bundle.putInt("key_funid", -1);
        bundle.putByteArray("key_data", node.getId().getBytes());
        com.tencent.mm.plugin.wear.model.b.a.aK(bundle);
        AppMethodBeat.o(30119);
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelOpened(Channel channel) {
        AppMethodBeat.i(30120);
        String path = channel.getPath();
        String nodeId = channel.getNodeId();
        File file = new File(com.tencent.mm.loader.j.b.aKS(), g.getMessageDigest(path.getBytes()));
        Log.i("MicroMsg.Wear.WearDataLayerService", "onChannelOpened %s %s %s", path, nodeId, file.getAbsolutePath());
        if (file.exists()) {
            file.delete();
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e2, "onChannelOpened", new Object[0]);
        }
        try {
            channel.receiveFile(new a().fWa(), Uri.fromFile(file), false);
            AppMethodBeat.o(30120);
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e3, "fuck Xiao Mi", new Object[0]);
            AppMethodBeat.o(30120);
        }
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onInputClosed(Channel channel, int i2, int i3) {
        AppMethodBeat.i(30121);
        String path = channel.getPath();
        Log.i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s %s %d %d", path, channel.getNodeId(), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0) {
            File file = new File(com.tencent.mm.loader.j.b.aKS(), g.getMessageDigest(path.getBytes()));
            Log.i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s, %d", file.getAbsolutePath(), Long.valueOf(file.length()));
            Bundle bundle = new Bundle();
            bundle.putInt("key_connecttype", 1);
            bundle.putInt("key_funid", b.aWs(path));
            bundle.putInt("key_sessionid", 0);
            bundle.putByteArray("key_data", file.getAbsolutePath().getBytes());
            com.tencent.mm.plugin.wear.model.b.a.aK(bundle);
        }
        AppMethodBeat.o(30121);
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onOutputClosed(Channel channel, int i2, int i3) {
        AppMethodBeat.i(30122);
        Log.i("MicroMsg.Wear.WearDataLayerService", "onOutputClosed %s %s %d %d", channel.getPath(), channel.getNodeId(), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(30122);
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelClosed(Channel channel, int i2, int i3) {
        AppMethodBeat.i(30123);
        Log.i("MicroMsg.Wear.WearDataLayerService", "onChannelClosed %s %s %d %d", channel.getPath(), channel.getNodeId(), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(30123);
    }
}
