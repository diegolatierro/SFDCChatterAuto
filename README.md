# Welcome to the QA Portal!

## Getting Started

All QA resources to information can be found on Wiki (<https://github.com/pagefreezer/QA/wiki>).

- When creating new Wiki article(s)/page(s), please creating it from pagefreezer (<https://github.com/pagefreezer/PageFreezer/wiki>), then link it to the QA wiki page.

This repo contains the following:

1. Test Data (currently available)
2. _Automation Scripts (soon to follow)_
3. _General built-in-house Tools (soon to follow)_

## Test Data

When creating test data, it's important to keep the level of organization of file structure as seen below, so we can find them easily in the future.

### Test Data: SAXHTMLParser
Base URL: TestData/WebPages/qa_tests_pagefreezer_v1/GH-2014

TestElementID | Tag    | Attribute          | Notes / Possible attribute values                                  | Public URL
------------- | ------ | ------------------ | ------------------------------------------------------------------ | ----------------
a_001         | a      | `href`             |                                                                    | /a_001.html
a_002         | a      | `href`             | link to video stored in wistia                                     | /a_002.html
base_001      | base   | `href`             |                                                                    | /base_001.html
source_001    | source | `src`              |                                                                    | /source_001.html
img_001       | img    | `src`              |                                                                    | /img_001.html
img_002       | img    | `data-original`    |                                                                    | /img_002.html
img_003       | img    | `data-full-size`   |                                                                    | /img_003.html
img_004       | img    | `data-thumb`       |                                                                    | /img_004.html
img_005       | img    | `data-url`         |                                                                    | /img_005.html
img_006       | img    | `data-src`         |                                                                    | /img_006.html
frame_001     | frame  | `src`              |                                                                    | /frame_001.html
frame_002     | frame  | `data-original`    |                                                                    | /frame_002.html
frame_003     | frame  | `data-full-size`   |                                                                    | /frame_003.html
frame_004     | frame  | `data-thumb`       |                                                                    | /frame_004.html
frame_005     | frame  | `data-url`         |                                                                    | /frame_005.html
frame_006     | frame  | `data-src`         |                                                                    | /frame_006.html
meta_001      | meta   | `http-equiv`       | content-type                                                       | /meta_001.htm
meta_002      | meta   | `http-equiv`       | refresh                                                            | /meta_002.htm
meta_001      | meta   | `content`          | charset                                                            | /meta_001.htm
meta_002      | meta   | `content`          | url                                                                | /meta_002.htm
meta_002      | meta   | `url`              |                                                                    | /meta_002.htm
map_001       | map    | `href`             |                                                                    | /map_001.html
map_001       | area   | `href`             |                                                                    | /map_001.html
object_001    | object | `data`             |                                                                    | /object_001.html
object_002    | object | `usemap`           |                                                                    | /object_002.html
object_003    | object | `archive`          |                                                                    | /object_003.html
object_003    | object | `codebase`         |                                                                    | /object_003.html
object_003    | embed  | `src`              |                                                                    | /object_003.html
link_001      | link   | `href`             | links prefixed w/ `javascript:` are failing                        | /link_001.html
link_002      | link   | `rel`              | stylesheet                                                         | /link_002.html
script_001    | script | `src`              |                                                                    | /script_001.html
script_002    | script | `expr:src`         | ignores any `script` tag w/ this attribute                         | /script_002.html
input_001     | input  | `src`              |                                                                    | /input_001.html
input_001     | input  | `value`            | when the link cannot be resolved it uses the root url from website | /input_001.html
iframe_001    | iframe | `src`              |                                                                    | /iframe_001.html
iframe_002    | iframe | `onload`           | `src`                                                              | /iframe_002.html
body_001      | body   | `onload`           | `location.href`                                                    | /body_001.html
body_002      | body   | `onload`           | `location.assign`                                                  | /body_002.html
body_003      | body   | `onload`           | `location.replace`                                                 | /body_003.html
body_004      | body   | `onload`           | `location.open`                                                    | /body_004.html
body_005      | body   | `onload`           | `window.open`                                                      | /body_005.html
body_006      | body   | `onload`           | `location.showModalDialog`                                         | /body_006.html
body_007      | body   | `onload`           | `window.showModalDialog`                                           | /body_007.html
body_008      | body   | `onload`           | `backgroud`                                                        | /body_008.html
body_009      | body   | `onload`           | `href`                                                             | /body_009.html
body_010      | body   | `background`       |                                                                    | /body_010.html
table_001     | table  | `background`       |                                                                    | /table_001.html
td_001        | td     | `background`       |                                                                    | /td_001.html
th_001        | th     | `background`       |                                                                    | /th_001.html
form_001      | form   | `action`           | `method`                                                           | /form_001.html
form_002      | form   | `enctype`          |                                                                    | /form_002.html
form_003      | form   | `accept`           |                                                                    | /form_003.html
form_004      | form   | `name`             |                                                                    | /form_004.html
form_005      | form   | `accept-charset`   |                                                                    | /form_005.html
select_001    | select | `name`             |                                                                    | /select_001.html
select_002    | select | `disabled`         |                                                                    | /select_002.html
select_003    | select | `disabled="false"` |                                                                    | /select_003.html

### Test Data: Character encoding
Base URL: TestData/WebPages/qa_tests_pagefreezer_v1/GH-2075

TestElementID | Tag  | Attribute                   | Notes / Possible attribute values                 | Public URL
------------- | ---- | --------------------------- | ------------------------------------------------- | --------------
meta_003|meta| http-equiv = "Content-Type" | Encoding test - 99 Chars | /meta_003.html
meta_004|meta| http-equiv = "Content-Type" | Encoding test - 101 Chars| /meta_004.html
meta_005|meta| http-equiv = "Content-Type" | Encoding test - blank | /meta_005.html
meta_006|meta| http-equiv = "Content-Type" | Encoding test - keyword 'null' | /meta_006.html
meta_007|meta| http-equiv = "Content-Type" | Encoding test - Single quotes with space | /meta_007.html
meta_008|meta| http-equiv = "Content-Type" | Encoding test - Single quotes with no space | /meta_008.html
meta_009|meta| http-equiv = "Content-Type" | Encoding test - Null test using double quotes | /meta_009.html
meta_010|meta| http-equiv = "Content-Type" | Encoding test - Null test using meta=cotent type | /meta_010.html
meta_011|meta| http-equiv = "Content-Type" | Encoding test - Special Characters | /meta_011.html
meta_012|meta| http-equiv = "Content-Type" | Encoding test - Chinese characters | /meta_012.html

### Test Data: Sitemaps
Base URL: TestData/WebPages/qa_tests_pagefreezer_v1/

TestElementID | Tag  | Attribute                   | Notes / Possible attribute values                 | Public URL
------------- | ---- | --------------------------- | ------------------------------------------------- | --------------
sitemap_001|sitemap| none | plain site map | ./sitemap__001.xml
sitemap_002|sitemap| changefreq | always| ./sitemap__002.xml
sitemap_003|sitemap| lastmod | set to Feb 28 will need to update for further tests | ./sitemap__003.xml

### Test Data: Banner images
Base URL: TestData/WebPages/qa_tests_pagefreezer_v1/GH-2075

TestElementID | Tag  | Attribute                   | Notes / Possible attribute values                 | Public URL
------------- | ---- | --------------------------- | ------------------------------------------------- | --------------
body_011|body| background image | .jpg file | /body_011.html
body_012|body| background image | .ashx file | /body_012.html
body_013|body| background image | javascript injection .ashx file| /body_013.html

### Test Data: PDF
Base URL: TestData/WebPages/qa_tests_pagefreezer_v1/GH-2094

TestElementID | Tag  | Attribute                   | Notes / Possible attribute values                 | Public URL
------------- | ---- | --------------------------- | ------------------------------------------------- | --------------
a_002|a| href | target="_blank" | /a_002.html
a_003|a| href | download | /a_003.html
object_004|object|  data | embed pdf to page| /object_004.html


## Folder Structure

### Example 1:

```
TestData/
└── WebPages
    ├── qa_tests_competition_heritrix3
        ├── <TestData competitors used>
    │   └── index.html
    ├── qa_tests_competition_nutch
        ├── <TestData competitors used>
    │   └── index.html
    └── qa_tests_pagefreezer_v1
        └── GH-2014
            └── <TestData to exercise SAXHTMLParser>
        └── GH-2075
            └── <TestData for Character Encoding>
        └── GH-2190
            └── <TestData for Banner images>
        └── GH-2094
            └── <TestData for pdf>
        └── index.html
        └── sitemap.xml
```

- As you can see from the above example,

  - TestData above, is an example of WebPages, and is separated by what was created by PageFreezer, and our competitors.

    - For each company an index.html was created to group the TestData
    - It's worth separating TestData by GitHub tickets, then ensure they are present in the common `index.html`

## Checklist before merging with this Repo

- [ ] Your folder/file structure aligns with this repo. (Pay close attention to the folder structure noted in the above example!)
- [ ] 'index.html' has been updated or created for the new TestData.
- [ ] Test Your code!

  - In the case for TestData, ensure it has been tested from a Webserver (i.e. mockup.pagefreezer.com)

    - More info on this can be found here: <https://github.com/pagefreezer/PageFreezer/wiki/QA---PageFreezer---Test-Data>
    - Use Test.PageFreezer.com, by adding a task for the corresponding TestData, to see how the crawler behaves.

- [ ] Update the README.md file to reflect your change/addition.
- [ ] Familiarize yourself with Code Review, before merging your code with this Repo:

  - Guideline (<https://github.com/pagefreezer/PageFreezer/wiki/Code-Review-Guideline>)
  - Process (<https://github.com/pagefreezer/PageFreezer/wiki/Code-Review-Process-v1.0>)
# SFDCChatterAuto
