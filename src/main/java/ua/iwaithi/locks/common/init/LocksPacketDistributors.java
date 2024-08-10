package ua.iwaithi.locks.common.init;


import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.PacketDistributor;

import java.util.List;
import java.util.stream.Stream;

public final class LocksPacketDistributors
{
	public static final PacketDistributor<Stream<ChunkAccess>> TRACKING_AREA = new PacketDistributor<>((pd, s) ->
		pkt ->
		{
			// Convert each chunk to a stream of tracking players
			// Merge all streams into one
			// Remove duplicate players
			// Send packet
			s.get()
				.flatMap(chunk -> (Stream<ServerPlayer>)((ServerChunkCache) chunk.getWorldForge().getChunkSource()).chunkMap.getPlayers(chunk.getPos(), false))
				.distinct()
				.forEach(p -> p.connection.send(pkt));
		}, NetworkDirection.PLAY_TO_CLIENT);

	private LocksPacketDistributors() {}
}