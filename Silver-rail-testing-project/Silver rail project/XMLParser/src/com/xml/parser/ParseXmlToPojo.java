package com.xml.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseXmlToPojo extends DefaultHandler {

	private static List<PostcodeStationWithCoord> data = new ArrayList<PostcodeStationWithCoord>();
	private static PostcodeStationWithCoord post = null;
	private static String text = null;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (qName) {
		case "PostcodeStationWithCoord": {
			post = new PostcodeStationWithCoord();
			break;
		}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "PostcodeStationWithCoord": {
			data.add(post);
			break;
		}
		case "Crs": {
			post.setCrs(text);
			break;
		}
		case "Distance": {
			post.setDistance(Double.parseDouble(text));
			break;
		}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text = String.copyValueOf(ch, start, length).trim();
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		ParseXmlToPojo handler = new ParseXmlToPojo();
		parser.parse(new File("response.xml"), handler);
		Collections.sort(data);
		System.out.println("====> " + data.get(2).getCrs());
	}
}