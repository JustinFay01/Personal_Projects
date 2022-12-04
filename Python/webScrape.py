from serpapi import GoogleSearch
import os, json

search_term = "Software Engineer Internship"
search_location = "United States"

params = {
  "api_key":"64c920246f7085550eb383fd7eae7c551c1239e619519e843ac2969a1ece863c",
  "device": "desktop",
  "engine": "google_jobs",
  "google_domain": "google.com",
  "q": search_term,
  "hl": "en",
  "gl": "us",
  "ijn" : 0,
  "location" : search_location
}

search = GoogleSearch(params)

search_results = []

job_is_present = True
while job_is_present:
  results = search.get_dict()

  if "error" not in results:
    for job in results:
      if job not in search_results:
        search_results.append(job)
    params["ijn"] += 1

  else:
    job_is_present = False
    print(results["error"])




print(json.dumps(search_results, indent=2))
print(len(search_results))
