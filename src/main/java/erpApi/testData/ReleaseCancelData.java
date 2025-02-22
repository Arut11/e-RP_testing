package erpApi.testData;

import models.ReleaseCancel;

public class ReleaseCancelData {

  public ReleaseCancel getReleaseCancelData() {
    return new ReleaseCancel()
        .setReason("Причина отмены указана")
        .setReasonFederalCode(1);
  }
}