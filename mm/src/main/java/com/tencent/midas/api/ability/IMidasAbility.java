package com.tencent.midas.api.ability;

import android.os.Bundle;

public interface IMidasAbility {
    void fromBundle(Bundle bundle);

    Bundle toBundle();
}
