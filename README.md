# Covid dataset loader

### Loads covid policy data from https://github.com/OxCGRT/covid-policy-tracker
Data are loaded to a MongoDB instance and are indexed by date.
This project has extremely low memory consumption (<40MB) and it will not be affected by the size of the dataset.

Basic unit tests cover 75% of the project.

TODO: add vaccination data as well (different source).