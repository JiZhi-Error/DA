package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
@k
public class BluetoothReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(19871);
        AppMethodBeat.o(19871);
    }
}
