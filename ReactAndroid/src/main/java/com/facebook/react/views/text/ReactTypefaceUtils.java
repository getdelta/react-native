/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.react.views.text;

import com.facebook.react.bridge.ReadableArray;

import java.util.ArrayList;
import java.util.List;

public class ReactTypefaceUtils {
  public static String parseFontVariant(ReadableArray fontVariantArray) {
    if (fontVariantArray == null || fontVariantArray.size() == 0) {
      return null;
    }

    List<String> features = new ArrayList<>();
    for (int i = 0; i < fontVariantArray.size(); i++) {
      // see https://docs.microsoft.com/en-us/typography/opentype/spec/featurelist
      switch (fontVariantArray.getString(i)) {
        case "small-caps":
          features.add("'smcp'");
          break;
        case "oldstyle-nums":
          features.add("'onum'");
          break;
        case "lining-nums":
          features.add("'lnum'");
          break;
        case "tabular-nums":
          features.add("'tnum'");
          break;
        case "proportional-nums":
          features.add("'pnum'");
          break;
      }
    }

    return String.join(", ", features);
  }
}
