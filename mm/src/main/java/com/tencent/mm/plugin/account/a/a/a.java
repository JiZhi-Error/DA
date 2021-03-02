package com.tencent.mm.plugin.account.a.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import java.util.LinkedList;

public interface a extends d {
    void clearFriendData();

    MStorageEx getAddrUploadStg();

    MStorage getFacebookFrdStg();

    MStorage getFrdExtStg();

    LinkedList getFriendData();

    MStorage getGoogleFriendStorage();

    MStorage getInviteFriendOpenStg();

    MAutoStorage getOldAccountFriendStorage();

    MStorage getQQGroupStg();

    MStorageEx getQQListStg();

    void removeSelfAccount(Context context);

    void setFriendData(LinkedList linkedList);

    void showAddrBookUploadConfirm(Activity activity, Runnable runnable, boolean z, int i2);

    boolean syncAddrBook(b bVar);

    void syncAddrBookAndUpload();

    void syncUploadMContactStatus(boolean z, boolean z2);

    void updateAllContact();
}
