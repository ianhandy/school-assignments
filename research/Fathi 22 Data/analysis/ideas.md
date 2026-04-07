# Fathi Eye-Tracking Study — Research Questions

*Algorithm visualization attention study. Three visualization styles (IRN, Galles, Metal), two algorithms (BFS, DFS), three skill levels (beginner, intermediate, advanced). Tobii eye-tracking. AOIs: Pseudocode, Geospatial Map, Queue, Stack.*

---

## Original Questions (Design-Focused)

### Q1 — Pseudocode/Map Attention Ratio by Visualization Style
Does the ratio of total pseudocode fixation time to geospatial map fixation time differ between Galles and Metal visualizations in BFS, and does this ratio predict fixation count on the Queue AOI?

**Metric:** `TFD_pseudocode / TFD_map` per participant  
**Test:** Mann-Whitney U (Galles vs Metal), Spearman correlation with Queue fixation count  
**Real-world takeaway:** If Metal produces a lower ratio, its richer visual output is pulling attention away from the code. The fix is concrete: delay map animation or animate the active pseudocode line.

---

### Q2 — Does Looking at the Map First Predict Less Total Time on Pseudocode?
Classify each participant as "map-first" or "pseudocode-first" using Time to First Fixation on each AOI. Test whether map-first viewers have lower Total Fixation Duration on pseudocode overall.

**Metric:** `Time to First Fixation` (pseudocode vs map), `Total Fixation Duration` on pseudocode  
**Test:** Mann-Whitney U (map-first vs pseudocode-first)  
**Real-world takeaway:** If map-first viewers under-read code, the visualization is silently failing them. Fix: delay map animation by 3–5 seconds, or have the pseudocode appear first with nothing else on screen.

---

### Q3 — Scanner vs. Deep Reader: Pseudocode Visit Pattern by Visualization Style
Compute `Visit Count / Total Fixation Duration` on pseudocode per participant. A high ratio = many brief check-ins (scanning). A low ratio = fewer, longer reads (deep processing). Does Galles vs Metal produce different distributions?

**Metric:** `Visit Count / Total Fixation Duration` on pseudocode  
**Test:** Mann-Whitney U (Galles vs Metal)  
**Real-world takeaway:** If a visualization produces mostly scanners, the pseudocode should be redesigned for scanning (highlight active line, minimal text). If it produces deep readers, it can afford more explanatory content per line.

---

### Q4 — Is Pseudocode Attention a Stable Individual Trait or Algorithm-Dependent?
For participants who appear in both BFS and DFS data, correlate their pseudocode/map ratio within-person across algorithms.

**Metric:** Within-person Spearman r of pseudocode/map ratio (BFS vs DFS)  
**Test:** Spearman correlation  
**Real-world takeaway:** High within-person correlation = learner trait (fix with curriculum interventions). Low correlation = algorithm/design drives it (fix with visualization redesign for the harder algorithm).

---

### Q5 — Do Early Non-Pseudocode Fixations Predict Less Total Pseudocode Engagement?
`Fixations Before` on pseudocode = fixation events before gaze ever lands on the pseudocode AOI. Correlate this with Total Fixation Duration on pseudocode.

**Metric:** `Fixations Before` (pseudocode), `Total Fixation Duration` (pseudocode)  
**Test:** Spearman correlation  
**Real-world takeaway:** If the relationship is strong, the first seconds of the video are the decisive window. Visualization designers should force pseudocode contact early — flash/pulse the pseudocode at video start, or use eye-tracking-gated playback.

---

## New Questions (Skill Level as Variable)

*Requires joining participant IDs (P02–P61) to a skill level mapping (beginner / intermediate / advanced).*

---

### Q6 — Inverted-U: Do Intermediates Read Pseudocode Most?
Do beginners and advanced learners both under-read pseudocode — beginners because they can't parse it, advanced because they don't need it — leaving intermediates as the primary pseudocode readers?

**Metric:** `Total Fixation Duration` on pseudocode, grouped by skill level  
**Test:** Kruskal-Wallis + pairwise Mann-Whitney U  
**Real-world takeaway:** If confirmed, pseudocode panels serve exactly one of three audience segments. Beginners need natural language or annotated pseudocode first. Advanced learners need a harder variant. Showing one pseudocode format to all three groups is a mismatch for two of them.

---

### Q7 — Does Visualization Style Only Distract Beginners?
Test whether the Galles–Metal difference in pseudocode/map ratio is significant for beginners but not for intermediate or advanced learners. Skill level × visualization style interaction on the attention ratio.

**Metric:** Pseudocode/map ratio, grouped by skill level × visualization style  
**Test:** Interaction term (or separate Mann-Whitney U per skill level subgroup)  
**Real-world takeaway:** If Metal only distracts beginners, Galles should be the default for intro courses and Metal reserved for advanced contexts. A direct design recommendation by course level — not just a general observation.

---

### Q8 — Do Intermediates Visit Queue/Stack Most? (Inverted-U on Data Structures)
Measure `Visit Count` on Queue and Stack by skill level. Prediction: beginners ignore them (don't know what they mean), advanced learners track them mentally without looking, intermediates return to them repeatedly to verify their mental model.

**Metric:** `Visit Count` on Queue and Stack, by skill level  
**Test:** Kruskal-Wallis + pairwise Mann-Whitney U  
**Real-world takeaway:** If the queue display is primarily used by intermediates, it's not a beginner affordance — it's a confirmation tool for partial understanding. Beginner-facing versions should replace the queue with a simpler "next to visit" callout. Advanced versions can omit it.

---

### Q9 — Does Mean Fixation Depth on Pseudocode Identify Passive vs Active Beginners?
Compute `Total Fixation Duration / Visit Count` on pseudocode (average depth per visit) for beginners only. Do active-processor beginners (longer visits) also show higher Visit Count on Queue and Stack — following the chain pseudocode → data structure → map?

**Metric:** `TFD / Visit Count` on pseudocode (beginners only), `Visit Count` on Queue and Stack  
**Test:** Spearman correlation within beginner group  
**Real-world takeaway:** If active-processor beginners show the pseudocode → queue → map chain but passive beginners do not, the visualization is not creating engagement on its own. A pre-question ("Which node will BFS visit third?") converts passive viewers to active processors. Cheap instructional intervention, no redesign needed.

---

### Q10 — Do Beginners Watching Metal Behave Like Passive TV Viewers?
Classify participants into quadrants: high-map%/low-pseudocode-visits ("passive watcher") vs low-map%/high-pseudocode-visits ("code reader"). Test whether beginners in the Metal condition cluster in the passive-watcher quadrant significantly more than any other skill × style combination.

**Metric:** `Percentage Fixated` on map, `Visit Count` on pseudocode, by skill level × visualization style  
**Test:** Chi-square or Fisher's exact on quadrant membership  
**Real-world takeaway:** If Metal reliably produces passive-watcher behavior in beginners, it should be considered an inappropriate design for introductory instruction regardless of aesthetic quality. Establishes a generalizable rule: minimize decorative visual complexity in algorithm animations for novice audiences.

---

## Notes on Data Requirements

| Question | Requires |
|---|---|
| Q1–Q5 | XLS aggregate files (already loaded) |
| Q6–Q10 | Skill level mapping: participant ID → {beginner, intermediate, advanced} |
| Q4 | Participant appears in both BFS and DFS files (same P-number across files) |
| Q8–Q10 | Queue/Stack AOI data from TSV export (not in XLS files) |
| Q9–Q10 | Sufficient beginner n for within-group analysis (min ~8–10 recommended) |
