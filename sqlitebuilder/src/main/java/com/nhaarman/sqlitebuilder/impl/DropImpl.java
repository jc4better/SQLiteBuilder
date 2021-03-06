/*
 *  Copyright 2015 Niek Haarman
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.nhaarman.sqlitebuilder.impl;

import com.nhaarman.sqlitebuilder.Drop;
import com.nhaarman.sqlitebuilder.DropTable;
import com.nhaarman.sqlitebuilder.DropTableIfExists;
import com.nhaarman.sqlitebuilder.RawSqlBuilder;
import com.nhaarman.sqlitebuilder.SqlPart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class DropImpl extends BaseSqlPart implements Drop {

  @NotNull
  @Override
  public DropTable table(@NotNull final String tableName) {
    return table(null, tableName);
  }

  @NotNull
  @Override
  public DropTable table(@Nullable final String databaseName, @NotNull final String tableName) {
    return new DropTableImpl(databaseName, tableName, this);
  }

  @NotNull
  @Override
  public DropTableIfExists tableIfExists(@NotNull final String tableName) {
    return tableIfExists(null, tableName);
  }

  @NotNull
  @Override
  public DropTableIfExists tableIfExists(@Nullable final String databaseName, @NotNull final String tableName) {
    return new DropTableIfExistsImpl(databaseName, tableName, this);
  }

  @Override
  public void prependTo(@NotNull final RawSqlBuilder builder) {
    builder.prepend("DROP");
  }

  @Nullable
  @Override
  public SqlPart previous() {
    return null;
  }
}
