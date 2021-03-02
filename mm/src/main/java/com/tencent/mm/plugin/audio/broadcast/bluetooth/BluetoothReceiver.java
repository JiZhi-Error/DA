package com.tencent.mm.plugin.audio.broadcast.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Set;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
@k
public class BluetoothReceiver extends BroadcastReceiver {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void onReceive(Context context, Intent intent) {
        char c2;
        Set<BluetoothDevice> bondedDevices;
        AppMethodBeat.i(223924);
        if (context == null || intent == null || Util.isNullOrNil(intent.getAction())) {
            AppMethodBeat.o(223924);
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            Log.d("MicroMsg.BluetoothReceiver", "getDefaultAdapter == null");
            AppMethodBeat.o(223924);
            return;
        }
        Log.i("MicroMsg.BluetoothReceiver", "dkbt action :" + intent.getAction());
        try {
            int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            if ((intExtra == 1 || intExtra == 0) && ((bondedDevices = defaultAdapter.getBondedDevices()) == null || bondedDevices.size() == 0)) {
                Log.d("MicroMsg.BluetoothReceiver", "getBondedDevices == null");
                AppMethodBeat.o(223924);
                return;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.BluetoothReceiver", "%s", Util.stackTraceToString(e2));
        }
        String action = intent.getAction();
        if (Util.isNullOrNil(action)) {
            AppMethodBeat.o(223924);
            return;
        }
        switch (action.hashCode()) {
            case -1692127708:
                if (action.equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1530327060:
                if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1435586571:
                if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 17117692:
                if (action.equals("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 545516589:
                if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1821585647:
                if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                a.V(intent);
                AppMethodBeat.o(223924);
                return;
            case 1:
                a.W(intent);
                AppMethodBeat.o(223924);
                return;
            case 2:
                a.X(intent);
                AppMethodBeat.o(223924);
                return;
            case 3:
                a.Y(intent);
                AppMethodBeat.o(223924);
                return;
            case 4:
                a.Z(intent);
                AppMethodBeat.o(223924);
                return;
            case 5:
                a.aa(intent);
                break;
        }
        AppMethodBeat.o(223924);
    }
}
