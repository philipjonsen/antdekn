/*
  Antdekn Explorer - Jakarta EE based blockchain explorer
  Copyright (C) 2020 The Unigrid Organization

  This program is free software: you can redistribute it and/or modify it under the
  terms of the GNU Affero General Public License as published by the Free Software
  Foundation, either version 3 of the License, or (at your option) any later
  version. This program also amends the license with additional terms as outlined
  in the addendum of the license terms.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY
  WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
  PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.

  The full license terms of this program are outlined in the files COPYING and
  COPYING.addendum, found in the root directory of this project repository as
  seen on <https://github.com/unigrid-project/antdekn>. Updated contact information
  can also be found on this project page. If you did not received a copy of the
  GNU Affero General Public License along with this program, please see
  <https://www.gnu.org/licenses/>.
*/

package org.unigrid.antdekm.storage.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.SortedSet;
import java.util.TreeSet;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address implements Serializable
{
	private String chainAddress;
	private SortedSet<Transaction> transactions = new TreeSet<>();
	private BigDecimal balance = BigDecimal.ZERO;

	public boolean addTransaction(Transaction t) {
		if (transactions.contains(t)) {
			return false;
		}

		// TODO: Increment the balance of the transaction (via RPC?)
		transactions.add(t);
		return true;
	}
}
