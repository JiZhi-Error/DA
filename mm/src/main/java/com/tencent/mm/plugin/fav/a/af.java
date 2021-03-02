package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.ane;
import java.util.List;

public interface af extends a {
    void checkFavItem(ane ane);

    void checkFavItem(List<amr> list);

    r getCheckCdnService();

    u getEditService();

    o getFavCdnService();

    q getFavCdnStorage();

    s getFavConfigStorage();

    t getFavEditInfoStorage();

    x getFavItemInfoStorage();

    aa getFavSearchStorage();

    int getFavSizeLimit(boolean z, int i2);

    int getFavSizeLimitInMB(boolean z, int i2);

    l getFavTagSetMgr();

    int getFileSizeLimit(boolean z);

    int getFileSizeLimitInMB(boolean z);

    int getImageSizeLimitInMB(boolean z);

    z getModService();

    ac getSendService();

    int getVideoSizeLimit(boolean z);

    int getVideoSizeLimitInMB(boolean z);
}
