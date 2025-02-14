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

package org.unigrid.antdekm.wallet;

import com.github.arteam.simplejsonrpc.client.JsonRpcParams;
import com.github.arteam.simplejsonrpc.client.ParamsType;
import com.github.arteam.simplejsonrpc.core.annotation.JsonRpcMethod;
import com.github.arteam.simplejsonrpc.core.annotation.JsonRpcParam;
import com.github.arteam.simplejsonrpc.core.annotation.JsonRpcService;
import javax.ejb.Stateless;
import org.unigrid.antdekm.wallet.model.block.Block;
import org.unigrid.antdekm.wallet.model.block.VerboseBlock;

@Stateless
public class BlockService extends AbstractWalletService<BlockService.Service>
{
	public BlockService() {
		super(BlockService.Service.class);
	}

	@JsonRpcService
	@JsonRpcParams(ParamsType.ARRAY)
	public interface Service
	{
		String COMMAND_GETBLOCK = "getblock";
		String COMMAND_GETBLOCKBYNUMBER = "getblockbynumber";
		String COMMAND_GETBLOCKCOUNT = "getblockcount";

		@JsonRpcMethod(COMMAND_GETBLOCK)
		VerboseBlock getBlock(@JsonRpcParam("blockhash") String blockHash);

		@JsonRpcMethod(COMMAND_GETBLOCKBYNUMBER)
		VerboseBlock getBlockByNumber(@JsonRpcParam("number") int number, @JsonRpcParam("txinfo") boolean txInfo);

		@JsonRpcMethod(COMMAND_GETBLOCKBYNUMBER)
		Block getBlockByNumber(@JsonRpcParam("number") int number);

		@JsonRpcMethod(COMMAND_GETBLOCKCOUNT)
		int getBlockCount();
	}
}
