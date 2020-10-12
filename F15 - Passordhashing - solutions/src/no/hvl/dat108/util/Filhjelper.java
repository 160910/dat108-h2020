package no.hvl.dat108.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Filhjelper {

	public static List<String> lesInnPassordFraFil(String filnavn) throws IOException {
		return Files.lines(Paths.get(filnavn)).collect(Collectors.toList());
	}

}
