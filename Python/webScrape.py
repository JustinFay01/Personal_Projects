from serpapi import GoogleSearch
import pandas

search_term = "Software Engineer Internship"
search_location = "United States"

params = {
  "api_key": "64c920246f7085550eb383fd7eae7c551c1239e619519e843ac2969a1ece863c",
  "device": "desktop",
  "engine": "google_jobs",
  "google_domain": "google.com",
  "q": search_term,
  "hl": "en",
  "gl": "us",
  "location" : search_location
}

search = GoogleSearch(params)

results = search.get_dict()
jobs_df = results
jobs_df = pd.DataFrame(jobs_df)
jobs_df. pd.concat([pd.DataFrane(jobs_df),
          pd.json_normalize(jobs_df['detected_extensions'])],
          axis=1).drop('detected.extensions',1)

jobs_df