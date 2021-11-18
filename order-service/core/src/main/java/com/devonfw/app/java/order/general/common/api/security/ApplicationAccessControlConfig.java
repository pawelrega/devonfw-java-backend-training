package com.devonfw.app.java.order.general.common.api.security;

import javax.inject.Named;

import com.devonfw.module.security.common.api.accesscontrol.AccessControlGroup;
import com.devonfw.module.security.common.base.accesscontrol.AccessControlConfig;

/**
 * Example of {@link AccessControlConfig} that used for testing.
 */
@Named
public class ApplicationAccessControlConfig extends AccessControlConfig {

  public static final String APP_ID = "order-service";

  private static final String PREFIX = APP_ID + ".";

  public static final String PERMISSION_FIND_BINARY_OBJECT = PREFIX + "FindBinaryObject";

  public static final String PERMISSION_SAVE_BINARY_OBJECT = PREFIX + "SaveBinaryObject";

  public static final String PERMISSION_DELETE_BINARY_OBJECT = PREFIX + "DeleteBinaryObject";

  public static final String GROUP_READ_MASTER_DATA = PREFIX + "ReadMasterData";

  public static final String GROUP_WAITER = PREFIX + "Waiter";

  public static final String GROUP_COOK = PREFIX + "Cook";

  public static final String GROUP_ADMIN = PREFIX + "Admin";


  /**
   * The constructor.
   */
  public ApplicationAccessControlConfig() {

    super();
    AccessControlGroup readMasterData = group(GROUP_READ_MASTER_DATA, PERMISSION_FIND_BINARY_OBJECT);
    AccessControlGroup waiter = group(GROUP_WAITER, readMasterData);
    AccessControlGroup cook = group(GROUP_COOK, readMasterData, PERMISSION_SAVE_BINARY_OBJECT);
    AccessControlGroup admin = group(GROUP_ADMIN, waiter, PERMISSION_SAVE_BINARY_OBJECT, PERMISSION_DELETE_BINARY_OBJECT);
  }

}